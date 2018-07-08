package org.jimkast.http.wire;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public final class BkNbNio implements Back, Front {
    private final Selector selector;
    private final ServerSocketChannel socket;

    public BkNbNio(int port) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel socket = ServerSocketChannel.open();
        socket.bind(new InetSocketAddress(port));
        socket.configureBlocking(false);
        socket.register(selector, SelectionKey.OP_ACCEPT);
        this.selector = selector;
        this.socket = socket;
    }

    public BkNbNio(Selector selector, ServerSocketChannel socket) {
        this.selector = selector;
        this.socket = socket;
    }

    @Override
    public void feed(Session session) throws IOException {
        try {
            while (true) {
                selector.select();
                for (SelectionKey key : selector.selectedKeys()) {
                    SocketChannel ch;
                    if (key.isAcceptable()) {
                        ch = socket.accept();
                    } else if (key.isReadable()) {
                        ch = (SocketChannel) key.channel();
                    } else {
                        continue;
                    }
                    ch.configureBlocking(true);
                    key.cancel();
                    session.accept(new ConnBlockingNio(ch));
                }
                selector.selectNow();
                socket.register(selector, SelectionKey.OP_ACCEPT);
            }
        } finally {
            selector.close();
            socket.close();
        }
    }

    @Override
    public void feed(org.takes.http.Back back) throws IOException {
        try {
            while (true) {
                selector.select();
                for (SelectionKey key : selector.selectedKeys()) {
                    SocketChannel ch;
                    if (key.isAcceptable()) {
                        ch = socket.accept();
                        ch.configureBlocking(false);
                        ch.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        ch = (SocketChannel) key.channel();
                        ch.configureBlocking(true);
                        key.cancel();
                        back.accept(ch.socket());
                    }
                }
                selector.selectNow();
                socket.register(selector, SelectionKey.OP_ACCEPT);
            }
        } finally {
            selector.close();
            socket.close();
        }
    }
}

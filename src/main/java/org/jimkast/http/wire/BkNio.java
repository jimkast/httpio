package org.jimkast.http.wire;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public final class BkNio implements Back {
    private final Selector selector;
    private final ServerSocketChannel socket;

    public BkNio(int port) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel socket = ServerSocketChannel.open();
        socket.bind(new InetSocketAddress(port));
        socket.configureBlocking(false);
        socket.register(selector, SelectionKey.OP_ACCEPT);
        this.selector = selector;
        this.socket = socket;
    }

    public BkNio(Selector selector, ServerSocketChannel socket) {
        this.selector = selector;
        this.socket = socket;
    }

    @Override
    public void trigger(Session session) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(512);
        try {
            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    if (key.isAcceptable()) {
                        SocketChannel ch = socket.accept();
                        ch.configureBlocking(false);
                        ch.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel ch = (SocketChannel) key.channel();
                        ch.read(buffer);
                        String r = new String(buffer.array());
//                        ch.configureBlocking(true);
                        session.consume(new ConnSocket(ch.socket()));
                    }
                    iter.remove();
                }
            }
        } finally {
            selector.close();
            socket.close();
        }
    }
}

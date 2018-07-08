package org.jimkast.net.wire.sun;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import org.jimkast.net.wire.Back;
import org.jimkast.net.wire.Connection;
import org.jimkast.net.wire.Session;

public final class FtSun implements Back {
    private final Selector selector;
    private final ServerSocketChannel socket;

    public FtSun(int port) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel socket = ServerSocketChannel.open();
        socket.bind(new InetSocketAddress(port));
        socket.configureBlocking(false);
        socket.register(selector, SelectionKey.OP_ACCEPT);
        this.selector = selector;
        this.socket = socket;
    }

    public FtSun(Selector selector, ServerSocketChannel socket) {
        this.selector = selector;
        this.socket = socket;
    }

    @Override
    public void feed(Session session) throws IOException {
        SelectionKey listenerKey = socket.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select(1000);
            Set<SelectionKey> selected = selector.selectedKeys();
            Iterator<SelectionKey> iter = selected.iterator();
            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();
                if (key.equals(listenerKey)) {
                    SocketChannel ch = socket.accept();
                    if (ch == null) {
                        continue; /* cancel something ? */
                    }
                    ch.configureBlocking(false);
                    SelectionKey newkey = ch.register(selector, SelectionKey.OP_READ);
                    Connection conn = new ConnSun(ch);
                    newkey.attach(conn);
                } else {
                    SocketChannel ch = (SocketChannel) key.channel();
                    try {
                        if (key.isReadable()) {
                            Connection conn = (Connection) key.attachment();
                            key.cancel();
                            ch.configureBlocking(true);
                            session.accept(conn);
                        }
                    } catch (CancelledKeyException | IOException e) {
                        ch.close();
                    }
                }
            }
            // call the selector just to process the cancelled keys
            selector.selectNow();
        }
    }
}

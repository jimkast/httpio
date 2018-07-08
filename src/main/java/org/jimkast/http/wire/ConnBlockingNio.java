package org.jimkast.http.wire;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;

public final class ConnBlockingNio implements Connection {
    private final SocketChannel ch;

    public ConnBlockingNio(SocketChannel ch) {
        this.ch = ch;
    }

    @Override
    public InputStream in() throws IOException {
        return ch.socket().getInputStream();
    }

    @Override
    public OutputStream out() throws IOException {
        return ch.socket().getOutputStream();
    }

    @Override
    public void close() throws IOException {
        ch.close();
    }
}

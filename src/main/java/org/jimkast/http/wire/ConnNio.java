package org.jimkast.http.wire;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;

public final class ConnNio implements Connection {
    private final SocketChannel ch;

    public ConnNio(SocketChannel ch) {
        this.ch = ch;
    }

    @Override
    public InputStream input() throws IOException {
        return new BufferedInputStream(Channels.newInputStream(ch));
    }

    @Override
    public OutputStream output() throws IOException {
        return Channels.newOutputStream(ch);
    }

    @Override
    public void close() throws IOException {
        ch.close();
    }
}

package org.jimkast.net.wire.sun;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SocketChannel;
import org.jimkast.net.wire.Connection;

public final class ConnSun implements Connection {
    private final SocketChannel ch;
    private final InputStream in;
    private final OutputStream out;

    public ConnSun(SocketChannel ch) {
        this(ch, new BufferedInputStream(new ReadStream(ch)), new BufferedOutputStream(new WriteStream(ch)));
    }

    public ConnSun(SocketChannel ch, InputStream in, OutputStream out) {
        this.ch = ch;
        this.in = in;
        this.out = out;
    }

    @Override
    public InputStream in() {
        return in;
    }

    @Override
    public OutputStream out() {
        return out;
    }

    @Override
    public void close() throws IOException {
        ch.close();
    }
}

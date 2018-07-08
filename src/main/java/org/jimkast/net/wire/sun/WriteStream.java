package org.jimkast.net.wire.sun;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public final class WriteStream extends OutputStream {
    private final SocketChannel ch;
    private ByteBuffer buf;
    private byte[] one = new byte[1];
    private boolean closed = false;

    public WriteStream(SocketChannel ch) {
        this(ch, 4096);
    }

    public WriteStream(SocketChannel ch, int buf) {
        this(ch, ByteBuffer.allocate(buf));
    }

    public WriteStream(SocketChannel ch, ByteBuffer buf) {
        this.ch = ch;
        this.buf = buf;
    }

    public synchronized void write(int b) throws IOException {
        one[0] = (byte) b;
        write(one, 0, 1);
    }

    public synchronized void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public synchronized void write(byte[] b, int off, int len) throws IOException {
        int l = len;
        if (closed) {
            throw new IOException("stream is closed");
        }
        int cap = buf.capacity();
        if (cap < len) {
            int diff = len - cap;
            buf = ByteBuffer.allocate(2 * (cap + diff));
        }
        buf.clear();
        buf.put(b, off, len);
        buf.flip();
        int n;
        while ((n = ch.write(buf)) < l) {
            l -= n;
            if (l == 0)
                return;
        }
    }

    public void close() throws IOException {
        if (closed)
            return;
        //server.logStackTrace ("Request.OS.close: isOpen="+channel.isOpen());
        ch.close();
        closed = true;
    }
}
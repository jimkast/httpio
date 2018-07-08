package org.jimkast.net.wire.sun;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public final class ReadStream extends InputStream {
    private final SocketChannel ch;
    private final ByteBuffer buf;
    private ByteBuffer markBuf;
    private final byte[] one = new byte[1];
    private boolean closed, eof, marked, reset = false;

    public ReadStream(SocketChannel ch) {
        this(ch, 8192);
    }

    public ReadStream(SocketChannel ch, int size) {
        this(ch, ByteBuffer.allocate(size));
    }

    public ReadStream(SocketChannel ch, ByteBuffer buf) {
        this.ch = ch;
        this.buf = buf;
        this.buf.clear();
    }

    public synchronized int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public synchronized int read() throws IOException {
        int result = read(one, 0, 1);
        if (result == 1) {
            return one[0] & 0xFF;
        } else {
            return -1;
        }
    }

    public synchronized int read(byte[] b, int off, int srclen) throws IOException {
        int canreturn, willreturn;
        if (closed) {
            throw new IOException("Stream closed");
        }
        if (eof) {
            return -1;
        }
        if (off < 0 || srclen < 0 || srclen > (b.length - off)) {
            throw new IndexOutOfBoundsException();
        }

        if (reset) { /* satisfy from markBuf */
            canreturn = markBuf.remaining();
            willreturn = canreturn > srclen ? srclen : canreturn;
            markBuf.get(b, off, willreturn);
            if (canreturn == willreturn) {
                reset = false;
            }
        } else { /* satisfy from channel */
            buf.clear();
            if (srclen < buf.capacity()) {
                buf.limit(srclen);
            }
            do {
                willreturn = ch.read(buf);
            } while (willreturn == 0);
            if (willreturn == -1) {
                eof = true;
                return -1;
            }
            buf.flip();
            buf.get(b, off, willreturn);

            if (marked) { /* copy into markBuf */
                try {
                    markBuf.put(b, off, willreturn);
                } catch (BufferOverflowException e) {
                    marked = false;
                }
            }
        }
        return willreturn;
    }

    public boolean markSupported() {
        return true;
    }

    /* Does not query the OS socket */
    public synchronized int available() throws IOException {
        if (closed) throw new IOException("Stream is closed");

        if (eof) return -1;

        if (reset) return markBuf.remaining();

        return buf.remaining();
    }

    public void close() throws IOException {
        if (closed) {
            return;
        }
        ch.close();
        closed = true;
    }

    public synchronized void mark(int readlimit) {
        if (closed)
            return;
        markBuf = ByteBuffer.allocate(readlimit);
        marked = true;
        reset = false;
    }

    public synchronized void reset() throws IOException {
        if (closed) {
            return;
        }
        if (!marked) {
            throw new IOException("Stream not marked");
        }
        marked = false;
        reset = true;
        markBuf.flip();
    }
}
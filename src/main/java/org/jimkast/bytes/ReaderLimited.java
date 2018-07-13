package org.jimkast.bytes;

import java.io.IOException;
import java.io.Reader;

public final class ReaderLimited extends Reader {
    private final Number limit;
    private final Reader origin;
    private long count = 0;

    public ReaderLimited(Number limit, Reader origin) {
        this.limit = limit;
        this.origin = origin;
    }

    public synchronized long remaining() {
        long limit = this.limit.longValue();
        return limit <= -1 ? Long.MAX_VALUE : limit - count;
    }

    @Override
    public int read() throws IOException {
        if (remaining() == 0) {
            return -1;
        }
        count++;
        return origin.read();
    }

    @Override
    public int read(char[] buf, int off, int len) throws IOException {
        int size = (int) Math.min(remaining(), len);
        if (size == 0) {
            return -1;
        }
        int read = origin.read(buf, off, size);
        if (read > 0) {
            count += read;
        }
        return read;
    }

    @Override
    public long skip(long n) throws IOException {
        return origin.skip(n);
    }

    @Override
    public boolean ready() throws IOException {
        return origin.ready();
    }

    @Override
    public boolean markSupported() {
        return origin.markSupported();
    }

    @Override
    public void mark(int limit) throws IOException {
        origin.mark(limit);
    }

    @Override
    public void reset() throws IOException {
        origin.reset();
    }

    @Override
    public void close() throws IOException {
        origin.close();
    }
}

package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.cactoos.iterable.Joined;
import org.jimkast.http.HttpOut;
import sun.net.www.http.ChunkedOutputStream;

public final class RsChunked implements HttpOut {
    private final HttpOut out;

    public RsChunked(HttpOut out) {
        this.out = out;
    }

    @Override
    public String line() {
        return out.line();
    }

    @Override
    public Iterable<String> headers() {
        return new Joined<>("Transfer-Encoding: chucked", out.headers());
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return this.out.print(new ChunkedOutputStream(new PrintStream(out)));
    }
}

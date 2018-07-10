package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.cactoos.iterable.Joined;
import org.jimkast.http.Header;
import org.jimkast.http.HttpOut;

public final class RsGzip implements HttpOut {
    private final HttpOut out;

    public RsGzip(HttpOut out) {
        this.out = out;
    }

    @Override
    public Iterable<String> line() {
        return out.line();
    }

    @Override
    public Iterable<Header> headers() {
        return new Joined<>(new Header.Simple("Content-Encoding", "gzip"), out.headers());
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return this.out.print(new GZIPOutputStream(out));
    }
}

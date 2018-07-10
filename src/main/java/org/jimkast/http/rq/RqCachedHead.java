package org.jimkast.http.rq;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.iterable.StickyIterable;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;

public final class RqCachedHead implements HttpIn {
    private final Iterable<String> line;
    private final Iterable<Header> headers;
    private final HttpIn body;

    public RqCachedHead(HttpIn origin) {
        this(
            () -> origin.line().iterator(),
            new StickyIterable<>(() -> origin.headers().iterator()),
            origin
        );
    }

    public RqCachedHead(Iterable<String> line, Iterable<Header> headers, HttpIn body) {
        this.line = line;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public Iterable<String> line() {
        return line;
    }

    @Override
    public Iterable<Header> headers() {
        return headers;
    }

    @Override
    public InputStream stream() throws IOException {
        return body.stream();
    }
}

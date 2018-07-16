package org.jimkast.http.rq;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.cactoos.iterable.StickyIterable;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;
import org.jimkast.iterable.ListEnvelope;

public final class RqCachedHead implements HttpIn {
    private final List<String> line;
    private final Iterable<Header> headers;
    private final HttpIn body;

    public RqCachedHead(HttpIn origin) {
        this(
            new ListEnvelope<>(origin::line),
            new StickyIterable<>(() -> origin.headers().iterator()),
            origin
        );
    }

    public RqCachedHead(List<String> line, Iterable<Header> headers, HttpIn body) {
        this.line = line;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public List<String> line() {
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

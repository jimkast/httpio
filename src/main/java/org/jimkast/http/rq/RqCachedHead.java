package org.jimkast.http.rq;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.iterable.StickyIterable;
import org.cactoos.scalar.StickyScalar;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;
import org.jimkast.text.TextEnvelope;

public final class RqCachedHead implements HttpIn {
    private final CharSequence line;
    private final Iterable<Header> headers;
    private final HttpIn body;

    public RqCachedHead(HttpIn origin) {
        this(
            new TextEnvelope(new StickyScalar<>(origin::line)),
            new StickyIterable<>(() -> origin.headers().iterator()),
            origin
        );
    }

    public RqCachedHead(CharSequence line, Iterable<Header> headers, HttpIn body) {
        this.line = line;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public String line() {
        return line.toString();
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

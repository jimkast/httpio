package org.jimkast.http.head;

import org.cactoos.iterable.StickyIterable;
import org.jimkast.http.Prop;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpLine;

public final class HeadSticky implements HttpHead {
    private final HttpLine line;
    private final Iterable<Prop> headers;

    public HeadSticky(HttpIn origin) {
        this(
            new HttpLine.Raw(() -> origin.line().iterator()),
            new StickyIterable<>(() -> origin.headers().iterator())
        );
    }

    private HeadSticky(HttpLine line, Iterable<Prop> headers) {
        this.line = line;
        this.headers = headers;
    }

    @Override
    public HttpLine line() {
        return line;
    }

    @Override
    public Iterable<Prop> headers() {
        return headers;
    }

}

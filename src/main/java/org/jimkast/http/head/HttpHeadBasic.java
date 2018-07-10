package org.jimkast.http.head;

import java.util.Collections;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;

public final class HttpHeadBasic implements HttpHead {
    private final Iterable<String> line;
    private final Iterable<Header> headers;

    public HttpHeadBasic(Iterable<String> line) {
        this(line, Collections.emptyList());
    }

    public HttpHeadBasic(Iterable<String> line, Iterable<Header> headers) {
        this.line = line;
        this.headers = headers;
    }

    @Override
    public Iterable<String> line() {
        return line;
    }

    @Override
    public Iterable<Header> headers() {
        return headers;
    }
}

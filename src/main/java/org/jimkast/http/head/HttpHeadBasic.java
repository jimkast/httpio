package org.jimkast.http.head;

import java.util.Collections;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpLine;

public final class HttpHeadBasic implements HttpHead {
    private final HttpLine line;
    private final Iterable<Header> headers;

    public HttpHeadBasic(HttpLine line) {
        this(line, Collections.emptyList());
    }

    public HttpHeadBasic(HttpLine line, Iterable<Header> headers) {
        this.line = line;
        this.headers = headers;
    }

    @Override
    public HttpLine line() {
        return line;
    }

    @Override
    public Iterable<Header> headers() {
        return headers;
    }
}

package org.jimkast.http.head;

import java.util.Collections;
import java.util.List;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;

public final class HttpHeadBasic implements HttpHead {
    private final List<String> line;
    private final Iterable<Header> headers;

    public HttpHeadBasic(List<String> line) {
        this(line, Collections.emptyList());
    }

    public HttpHeadBasic(List<String> line, Iterable<Header> headers) {
        this.line = line;
        this.headers = headers;
    }

    @Override
    public List<String> line() {
        return line;
    }

    @Override
    public Iterable<Header> headers() {
        return headers;
    }
}

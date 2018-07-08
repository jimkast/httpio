package org.jimkast.http.head;

import java.util.Collections;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;

public final class HttpHeadBasic implements HttpHead {
    private final CharSequence line;
    private final Iterable<Header> headers;

    public HttpHeadBasic(CharSequence line) {
        this(line, Collections.emptyList());
    }

    public HttpHeadBasic(CharSequence line, Iterable<Header> headers) {
        this.line = line;
        this.headers = headers;
    }

    @Override
    public String line() {
        return line.toString();
    }

    @Override
    public Iterable<Header> headers() {
        return headers;
    }
}

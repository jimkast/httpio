package org.jimkast.http.head;

import java.util.Collections;
import org.jimkast.http.HttpHead;

public final class HttpHeadBasic implements HttpHead {
    private final CharSequence line;
    private final Iterable<String> headers;

    public HttpHeadBasic(CharSequence line) {
        this(line, Collections.emptyList());
    }

    public HttpHeadBasic(CharSequence line, Iterable<String> headers) {
        this.line = line;
        this.headers = headers;
    }

    @Override
    public String line() {
        return line.toString();
    }

    @Override
    public Iterable<String> headers() {
        return headers;
    }
}

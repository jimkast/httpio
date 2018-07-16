package org.jimkast.http.head;

import java.util.Arrays;
import java.util.Collections;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpLine;

public final class HttpHeadBasic implements HttpHead {
    private final HttpLine line;
    private final Iterable<Header> headers;

    public HttpHeadBasic(Number status) {
        this(new HttpStatusLine(status));
    }

    public HttpHeadBasic(HttpLine line) {
        this(line, Collections.emptyList());
    }

    public HttpHeadBasic(Number status, Header... headers) {
        this(status, Arrays.asList(headers));
    }

    public HttpHeadBasic(Number status, Iterable<Header> headers) {
        this(new HttpStatusLine(status), headers);
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

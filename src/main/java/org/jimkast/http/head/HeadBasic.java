package org.jimkast.http.head;

import java.util.Arrays;
import java.util.Collections;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpLine;
import org.jimkast.map.Prop;

public final class HeadBasic implements HttpHead {
    private final HttpLine line;
    private final Iterable<Prop> headers;

    public HeadBasic(Number status) {
        this(new StatusLineBasic(status));
    }

    public HeadBasic(HttpLine line) {
        this(line, Collections.emptyList());
    }

    public HeadBasic(Number status, Prop... headers) {
        this(status, Arrays.asList(headers));
    }

    public HeadBasic(Number status, Iterable<Prop> headers) {
        this(new StatusLineBasic(status), headers);
    }

    public HeadBasic(HttpLine line, Iterable<Prop> headers) {
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

package org.jimkast.http.rq;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import org.cactoos.Input;
import org.cactoos.io.InputOf;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpLine;
import org.jimkast.http.head.HeadBasic;
import org.jimkast.map.Prop;

public final class RqBasic implements HttpIn {
    private final HttpHead head;
    private final Input body;

    public RqBasic(HttpLine line) {
        this(line, new InputOf(new byte[0]));
    }

    public RqBasic(HttpLine line, Input body) {
        this(line, Collections.emptyList(), body);
    }

    public RqBasic(HttpLine line, Iterable<Prop> headers, Input body) {
        this(new HeadBasic(line, headers), body);
    }

    public RqBasic(Input body) {
        this(new RqEmpty(), body);
    }

    public RqBasic(HttpHead head, Input body) {
        this.head = head;
        this.body = body;
    }

    @Override
    public HttpLine line() {
        return head.line();
    }

    @Override
    public Iterable<Prop> headers() {
        return head.headers();
    }

    @Override
    public InputStream stream() throws IOException {
        try {
            return body.stream();
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

}

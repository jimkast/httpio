package org.jimkast.http.rq;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import org.cactoos.Input;
import org.cactoos.io.InputOf;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpIn;
import org.jimkast.http.head.HttpHeadBasic;

public final class RqBasic implements HttpIn {
    private final HttpHead head;
    private final Input body;

    public RqBasic(Iterable<String> line) {
        this(line, new InputOf(new byte[0]));
    }

    public RqBasic(Iterable<String> line, Input body) {
        this(line, Collections.emptyList(), body);
    }

    public RqBasic(Iterable<String> line, Iterable<Header> headers, Input body) {
        this(new HttpHeadBasic(line, headers), body);
    }

    public RqBasic(HttpHead head, Input body) {
        this.head = head;
        this.body = body;
    }

    @Override
    public Iterable<String> line() {
        return head.line();
    }

    @Override
    public Iterable<Header> headers() {
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

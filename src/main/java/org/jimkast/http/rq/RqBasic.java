package org.jimkast.http.rq;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import org.cactoos.Input;
import org.cactoos.io.InputOf;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpIn;
import org.jimkast.http.head.HttpHeadBasic;

public final class RqBasic implements HttpIn {
    private final HttpHead head;
    private final Input body;

    public RqBasic(CharSequence line) {
        this(line, new InputOf(new byte[0]));
    }

    public RqBasic(CharSequence line, Input body) {
        this(line, Collections.emptyList(), body);
    }

    public RqBasic(CharSequence line, Iterable<String> headers, Input body) {
        this(new HttpHeadBasic(line, headers), body);
    }

    public RqBasic(HttpHead head, Input body) {
        this.head = head;
        this.body = body;
    }

    @Override
    public String line() {
        return head.line();
    }

    @Override
    public Iterable<String> headers() {
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

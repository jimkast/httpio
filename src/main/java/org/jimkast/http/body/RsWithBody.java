package org.jimkast.http.body;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Input;
import org.cactoos.io.InputOf;
import org.jimkast.bytes.BytesSource;
import org.jimkast.bytes.InputAsByteSource;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadRsEmpty;

public final class RsWithBody implements HttpOut {
    private final BytesSource body;
    private final HttpOut origin;

    public RsWithBody(CharSequence body) {
        this(new InputOf(body));
    }

    public RsWithBody(CharSequence body, HttpHead head) {
        this(new InputOf(body));
    }

    public RsWithBody(CharSequence body, HttpOut origin) {
        this(new InputOf(body), origin);
    }

    public RsWithBody(String body, HttpOut origin) {
        this(new InputOf(body), origin);
    }

    public RsWithBody(Input body) {
        this(new InputAsByteSource(body));
    }

    public RsWithBody(Input body, HttpHead head) {
        this(new InputAsByteSource(body), head);
    }

    public RsWithBody(Input body, HttpOut origin) {
        this(new InputAsByteSource(body), origin);
    }

    public RsWithBody(BytesSource body) {
        this(body, new HeadRsEmpty());
    }

    public RsWithBody(BytesSource body, HttpHead head) {
        this(body, new RsBasic(head));
    }

    public RsWithBody(BytesSource body, HttpOut origin) {
        this.body = body;
        this.origin = origin;
    }

    @Override
    public HttpHead head() {
        return origin.head();
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return body.print(out);
    }
}

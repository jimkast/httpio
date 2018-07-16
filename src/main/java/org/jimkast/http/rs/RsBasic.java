package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import org.cactoos.Input;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpLine;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HttpHeadBasic;
import org.jimkast.http.head.HttpStatusLine;
import org.jimkast.io.BytesSource;
import org.jimkast.io.bs.BsInput;

public final class RsBasic implements HttpOut {
    private final HttpHead head;
    private final BytesSource body;

    public RsBasic() {
        this(200);
    }

    public RsBasic(Number code) {
        this(new HttpStatusLine(code));
    }

    public RsBasic(HttpLine line) {
        this(line, BytesSource.EMPTY);
    }

    public RsBasic(Number code, BytesSource body) {
        this(new HttpStatusLine(code), body);
    }

    public RsBasic(HttpLine line, BytesSource body) {
        this(line, Collections.emptyList(), body);
    }

    public RsBasic(Number code, Iterable<Header> headers) {
        this(new HttpStatusLine(code), headers, BytesSource.EMPTY);
    }

    public RsBasic(Number code, Iterable<Header> headers, BytesSource body) {
        this(new HttpStatusLine(code), headers, body);
    }

    public RsBasic(HttpLine line, Iterable<Header> headers, BytesSource body) {
        this(new HttpHeadBasic(line, headers), body);
    }

    public RsBasic(HttpHead head) {
        this(head, BytesSource.EMPTY);
    }

    public RsBasic(Input body) {
        this(new BsInput(body));
    }

    public RsBasic(BytesSource body) {
        this(new RsEmpty(), body);
    }

    public RsBasic(HttpHead head, Input body) {
        this(head, new BsInput(body));
    }

    public RsBasic(HttpHead head, BytesSource body) {
        this.head = head;
        this.body = body;
    }

    @Override
    public HttpLine line() {
        return head.line();
    }

    @Override
    public Iterable<Header> headers() {
        return head.headers();
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        return body.print(out);
    }
}

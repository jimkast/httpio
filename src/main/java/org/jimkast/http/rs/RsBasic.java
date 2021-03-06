package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Input;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpLine;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadBasic;
import org.jimkast.io.BytesSource;
import org.jimkast.io.bs.BsInput;
import org.jimkast.map.Prop;

public final class RsBasic implements HttpOut {
    private final HttpHead head;
    private final BytesSource body;

    public RsBasic() {
        this(200);
    }

    public RsBasic(Number code) {
        this(new HeadBasic(code));
    }

    public RsBasic(Number code, BytesSource body) {
        this(new HeadBasic(code), body);
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
    public Iterable<Prop> headers() {
        return head.headers();
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        return body.print(out);
    }
}

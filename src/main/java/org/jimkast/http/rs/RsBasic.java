package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import org.cactoos.Input;
import org.jimkast.bytes.BytesSource;
import org.jimkast.bytes.InputAsByteSource;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.RsEmpty;
import org.jimkast.http.head.HttpHeadBasic;
import org.jimkast.http.head.HttpStatusLine;

public final class RsBasic implements HttpOut {
    private final HttpHead head;
    private final BytesSource body;

    public RsBasic() {
        this("HTTP/1.1 200 OK");
    }

    public RsBasic(Number code) {
        this(new HttpStatusLine(code));
    }

    public RsBasic(CharSequence line) {
        this(line, BytesSource.EMPTY);
    }

    public RsBasic(Number code, BytesSource body) {
        this(new HttpStatusLine(code), body);
    }

    public RsBasic(CharSequence line, BytesSource body) {
        this(line, Collections.emptyList(), body);
    }

    public RsBasic(Number code, Iterable<String> headers) {
        this(new HttpStatusLine(code), headers, BytesSource.EMPTY);
    }

    public RsBasic(Number code, Iterable<String> headers, BytesSource body) {
        this(new HttpStatusLine(code), headers, body);
    }

    public RsBasic(CharSequence line, Iterable<String> headers, BytesSource body) {
        this(new HttpHeadBasic(line, headers), body);
    }

    public RsBasic(HttpHead head) {
        this(head, BytesSource.EMPTY);
    }

    public RsBasic(Input body) {
        this(new InputAsByteSource(body));
    }

    public RsBasic(BytesSource body) {
        this(new RsEmpty(), body);
    }

    public RsBasic(HttpHead head, Input body) {
        this(head, new InputAsByteSource(body));
    }

    public RsBasic(HttpHead head, BytesSource body) {
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
    public long print(OutputStream out) throws IOException {
        return body.print(out);
    }
}

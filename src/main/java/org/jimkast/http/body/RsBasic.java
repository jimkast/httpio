package org.jimkast.http.body;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Input;
import org.jimkast.bytes.BytesSource;
import org.jimkast.bytes.InputAsByteSource;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpOut;

public final class RsBasic implements HttpOut {
    private final HttpHead head;
    private final BytesSource body;

    public RsBasic(HttpHead head) {
        this(head, BytesSource.EMPTY);
    }

    public RsBasic(HttpHead head, Input body) {
        this(head, new InputAsByteSource(body));
    }

    public RsBasic(HttpHead head, BytesSource body) {
        this.head = head;
        this.body = body;
    }

    @Override
    public HttpHead head() {
        return head;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return body.print(out);
    }
}

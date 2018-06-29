package org.jimkast.v2.body;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.v2.HttpHead;
import org.jimkast.v2.HttpOut;

public final class HttpWithHead implements HttpOut {
    private final HttpHead head;
    private final HttpOut origin;

    public HttpWithHead(HttpHead head, HttpOut origin) {
        this.head = head;
        this.origin = origin;
    }

    @Override
    public HttpHead head() {
        return head;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return origin.print(out);
    }
}

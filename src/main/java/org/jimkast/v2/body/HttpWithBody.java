package org.jimkast.v2.body;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Input;
import org.jimkast.bytes.BytesSource;
import org.jimkast.bytes.InputAsByteSource;
import org.jimkast.v2.HttpHead;
import org.jimkast.v2.HttpOut;

public final class HttpWithBody implements HttpOut {
    private final BytesSource body;
    private final HttpOut origin;

    public HttpWithBody(Input body, HttpOut origin) {
        this(new InputAsByteSource(body), origin);
    }

    public HttpWithBody(BytesSource body, HttpOut origin) {
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

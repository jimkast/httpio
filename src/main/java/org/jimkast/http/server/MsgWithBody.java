package org.jimkast.http.server;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Text;
import org.jimkast.http.Header;
import org.jimkast.http.HttpOutput;
import org.jimkast.bytes.BytesSource;

public final class MsgWithBody implements HttpOutput {
    private final HttpOutput origin;

    public MsgWithBody(HttpOutput origin) {
        this.origin = origin;
    }

    @Override
    public Text line() {
        return origin.line();
    }

    @Override
    public Iterable<Header> headers() {
        return origin.headers();
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        return origin.print(out);
    }
}

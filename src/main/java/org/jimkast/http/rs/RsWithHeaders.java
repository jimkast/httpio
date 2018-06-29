package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.iterable.Joined;
import org.jimkast.http.Header;
import org.jimkast.http.HttpOutput;

public final class RsWithHeaders implements HttpOutput {
    private final HttpOutput origin;
    private final Iterable<Header> headers;

    public RsWithHeaders(HttpOutput origin, Iterable<Header> headers) {
        this.origin = origin;
        this.headers = headers;
    }

    @Override
    public String line() {
        return origin.line();
    }

    @Override
    public Iterable<Header> headers() {
        return new Joined<>(
            origin.headers(),
            headers
        );
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return origin.print(out);
    }
}

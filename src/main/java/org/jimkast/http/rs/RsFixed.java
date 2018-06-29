package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import org.jimkast.bytes.BytesSource;
import org.jimkast.http.Header;
import org.jimkast.http.HttpOutput;

public final class RsFixed implements HttpOutput {
    private final CharSequence line;
    private final Iterable<Header> headers;
    private final BytesSource body;

    public RsFixed(CharSequence line, Header... headers) {
        this(line, Arrays.asList(headers));
    }

    public RsFixed(CharSequence line, Iterable<Header> headers) {
        this(line, headers, BytesSource.EMPTY);
    }

    public RsFixed(CharSequence line, Iterable<Header> headers, BytesSource body) {
        this.line = line;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public String line() {
        return line.toString();
    }

    @Override
    public Iterable<Header> headers() {
        return headers;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return body.print(out);
    }
}

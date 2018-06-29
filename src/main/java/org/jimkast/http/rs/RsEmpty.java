package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import org.jimkast.http.Header;
import org.jimkast.http.HttpOutput;

public final class RsEmpty implements HttpOutput {
    @Override
    public String line() {
        return "HTTP1/1 200 OK";
    }

    @Override
    public Iterable<Header> headers() {
        return Collections.emptyList();
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return 0;
    }
}

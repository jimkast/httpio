package org.jimkast.http.rs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;

public final class RsEmpty implements HttpIn, HttpOut {
    private static final Iterable<String> LINE = Arrays.asList("HTTP1/1", "200", "OK");

    @Override
    public Iterable<String> line() {
        return LINE;
    }

    @Override
    public Iterable<Header> headers() {
        return Collections.emptyList();
    }

    @Override
    public InputStream stream() throws IOException {
        return new ByteArrayInputStream(new byte[0]);
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return 0;
    }
}

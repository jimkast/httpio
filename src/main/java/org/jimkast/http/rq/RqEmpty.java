package org.jimkast.http.rq;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;

public final class RqEmpty implements HttpIn, HttpOut {
    private static final List<String> LINE = Arrays.asList("GET", "/", "HTTP1/1");

    @Override
    public List<String> line() {
        return LINE;
    }

    @Override
    public Iterable<Header> headers() {
        return Collections.emptyList();
    }

    @Override
    public InputStream stream() {
        return new ByteArrayInputStream(new byte[0]);
    }

    @Override
    public long print(OutputStream out) {
        return 0;
    }
}

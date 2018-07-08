package org.jimkast.http.rq;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;

public final class RqEmpty implements HttpIn, HttpOut {

    @Override
    public String line() {
        return "GET / HTTP1/1";
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

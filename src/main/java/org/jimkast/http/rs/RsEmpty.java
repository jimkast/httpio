package org.jimkast.http.rs;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpLine;
import org.jimkast.http.HttpOut;
import org.jimkast.io.BytesSource;
import org.jimkast.map.Prop;

public final class RsEmpty implements HttpIn, HttpOut {
    private static final HttpLine LINE = new HttpLine.Raw("HTTP/1.1", "200", "OK");

    @Override
    public HttpLine line() {
        return LINE;
    }

    @Override
    public Iterable<Prop> headers() {
        return Collections.emptyList();
    }

    @Override
    public InputStream stream() {
        return new ByteArrayInputStream(new byte[0]);
    }

    @Override
    public BytesSource print(OutputStream out) {
        return this;
    }
}

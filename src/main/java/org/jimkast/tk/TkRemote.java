package org.jimkast.tk;

import java.io.IOException;
import org.jimkast.http.HttpClientMapping;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.net.bk.wire.HttpCodec;

public final class TkRemote implements HttpClientMapping {
    private final HttpCodec wire;

    public TkRemote(HttpCodec wire) {
        this.wire = wire;
    }

    @Override
    public HttpIn exchange(HttpOut request) throws IOException {
        return wire.write(request).read();
    }
}

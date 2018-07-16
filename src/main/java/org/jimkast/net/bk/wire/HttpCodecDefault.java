package org.jimkast.net.bk.wire;

import java.io.IOException;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.net.wire.Connection;

public final class HttpCodecDefault implements HttpCodec {
    private final Connection conn;

    public HttpCodecDefault(Connection conn) {
        this.conn = conn;
    }

    @Override
    public HttpIn read() throws IOException {
        return null;
    }

    @Override
    public HttpCodec write(HttpOut out) throws IOException {
        return this;
    }
}

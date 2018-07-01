package org.jimkast.http.wire;

import java.io.IOException;

public final class SrvConnPool implements Server {
    private final Server origin;

    public SrvConnPool(Server origin) {
        this.origin = origin;
    }

    @Override
    public Connection accept() throws IOException {
        Connection conn = origin.accept();
        return conn;
    }
}

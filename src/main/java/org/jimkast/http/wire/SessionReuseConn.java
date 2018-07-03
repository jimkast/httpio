package org.jimkast.http.wire;

import java.io.IOException;

public final class SessionReuseConn implements Session {
    private final Session origin;

    public SessionReuseConn(Session origin) {
        this.origin = origin;
    }

    @Override
    public void consume(Connection channel) throws IOException {
        while (true) {
            origin.consume(channel);
        }
    }
}

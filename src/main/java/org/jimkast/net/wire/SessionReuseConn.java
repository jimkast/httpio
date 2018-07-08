package org.jimkast.net.wire;

import java.io.IOException;

public final class SessionReuseConn implements Session {
    private final Session origin;

    public SessionReuseConn(Session origin) {
        this.origin = origin;
    }

    @Override
    public void accept(Connection channel) throws IOException {
        while (true) {
            origin.accept(channel);
        }
    }
}

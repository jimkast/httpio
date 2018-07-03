package org.jimkast.http.wire;

import java.io.IOException;

public interface Session {
    void consume(Connection channel) throws IOException;
}

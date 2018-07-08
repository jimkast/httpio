package org.jimkast.http.wire;

import java.io.IOException;

public interface Session {
    void accept(Connection channel) throws IOException;
}

package org.jimkast.net.wire;

import java.io.IOException;

public interface Session {
    void accept(Connection channel) throws IOException;
}

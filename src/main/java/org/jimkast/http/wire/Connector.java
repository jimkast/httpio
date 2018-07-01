package org.jimkast.http.wire;

import java.io.IOException;

public interface Connector {
    void accept(Connection channel) throws IOException;
}

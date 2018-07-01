package org.jimkast.http.wire;

import java.io.IOException;

public interface Server {
    Connection accept() throws IOException;
}

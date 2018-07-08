package org.jimkast.net.wire;

import java.io.IOException;

public interface Back {
    void feed(Session session) throws IOException;
}

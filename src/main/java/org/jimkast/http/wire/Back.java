package org.jimkast.http.wire;

import java.io.IOException;

public interface Back {
    void feed(Session session) throws IOException;
}

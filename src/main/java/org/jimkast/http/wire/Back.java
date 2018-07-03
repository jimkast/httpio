package org.jimkast.http.wire;

import java.io.IOException;

public interface Back {
    void trigger(Session session) throws IOException;
}

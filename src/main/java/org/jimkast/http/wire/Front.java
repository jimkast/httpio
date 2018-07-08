package org.jimkast.http.wire;

import java.io.IOException;
import org.takes.http.Back;

public interface Front {
    void feed(Back session) throws IOException;
}

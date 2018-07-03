package org.jimkast.http.bk.wire;

import java.io.IOException;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;

public interface HttpCodec {
    HttpIn parse() throws IOException;

    void send(HttpOut out) throws IOException;
}

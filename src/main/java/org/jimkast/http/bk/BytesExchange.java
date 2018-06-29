package org.jimkast.http.bk;

import java.io.IOException;
import java.io.InputStream;
import org.jimkast.bytes.BytesSource;

public interface BytesExchange {
    BytesSource exchange(InputStream input) throws IOException;
}

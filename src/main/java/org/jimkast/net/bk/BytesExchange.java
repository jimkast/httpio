package org.jimkast.net.bk;

import java.io.IOException;
import java.io.InputStream;
import org.jimkast.io.BytesSource;

public interface BytesExchange {
    BytesSource exchange(InputStream input) throws IOException;
}

package org.jimkast.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamNoClose extends FilterInputStream {
    public InputStreamNoClose(InputStream origin) {
        super(origin);
    }

    @Override
    public void close() throws IOException {

    }
}

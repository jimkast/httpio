package org.jimkast.io;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class OutputStreamNoClose extends FilterOutputStream {
    public OutputStreamNoClose(OutputStream origin) {
        super(origin);
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }
}

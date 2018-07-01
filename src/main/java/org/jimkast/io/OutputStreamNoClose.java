package org.jimkast.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class OutputStreamNoClose extends FilterOutputStream {
    public OutputStreamNoClose(OutputStream origin) {
        super(origin);
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }
}

package org.jimkast.http.wire;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Connection extends Closeable {
    InputStream input() throws IOException;

    OutputStream output() throws IOException;

    @Override
    void close() throws IOException;
}

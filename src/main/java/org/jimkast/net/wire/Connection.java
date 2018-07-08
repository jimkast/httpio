package org.jimkast.net.wire;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Connection extends Closeable {
    InputStream in() throws IOException;

    OutputStream out() throws IOException;

    @Override
    void close() throws IOException;
}

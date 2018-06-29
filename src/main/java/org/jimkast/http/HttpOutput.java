package org.jimkast.http;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.bytes.BytesSource;

public interface HttpOutput extends BytesSource {
    String line();

    Iterable<Header> headers();

    @Override
    long print(OutputStream out) throws IOException;
}

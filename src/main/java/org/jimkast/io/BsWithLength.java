package org.jimkast.io;

import java.io.IOException;
import java.io.OutputStream;

public interface BsWithLength extends BytesSource {
    long length();

    @Override
    BytesSource print(OutputStream out) throws IOException;
}

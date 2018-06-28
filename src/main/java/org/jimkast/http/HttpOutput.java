package org.jimkast.http;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Text;
import org.jimkast.bytes.BytesSource;

public interface HttpOutput extends BytesSource {
    Text line();

    Iterable<Header> headers();

    @Override
    BytesSource print(OutputStream out) throws IOException;
}

package org.jimkast.bytes;

import java.io.IOException;
import java.io.Writer;

public interface TextSource {
    TextSource print(Writer out) throws IOException;
}

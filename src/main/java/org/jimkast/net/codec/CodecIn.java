package org.jimkast.net.codec;

import java.io.InputStream;

public interface CodecIn<T> {
    T decode(InputStream input);
}

package org.jimkast.net.codec;

import org.jimkast.io.BytesSource;

public interface CodecOut<T> {
    BytesSource encode(T data);
}

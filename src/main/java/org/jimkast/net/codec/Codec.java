package org.jimkast.net.codec;

import java.io.InputStream;
import org.jimkast.io.BytesSource;

public interface Codec<T> extends CodecIn<T>, CodecOut<T> {
    @Override
    T decode(InputStream input);

    @Override
    BytesSource encode(T data);
}

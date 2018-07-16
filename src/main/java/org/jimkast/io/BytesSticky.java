package org.jimkast.io;

import org.cactoos.Bytes;
import org.cactoos.Scalar;
import org.cactoos.scalar.StickyScalar;

public final class BytesSticky implements Bytes {
    private final Scalar<byte[]> origin;

    public BytesSticky(Bytes origin) {
        this(new StickyScalar<>(origin::asBytes));
    }

    public BytesSticky(Scalar<byte[]> origin) {
        this.origin = origin;
    }

    @Override
    public byte[] asBytes() throws Exception {
        return origin.value();
    }
}

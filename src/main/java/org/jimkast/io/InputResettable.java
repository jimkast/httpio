package org.jimkast.io;

import java.io.InputStream;
import org.cactoos.Input;
import org.cactoos.Scalar;
import org.cactoos.scalar.StickyScalar;

public final class InputResettable implements Input {
    private final Scalar<InputStream> cache;

    public InputResettable(Input origin) {
        this(new StickyScalar<>(origin::stream));
    }

    public InputResettable(Scalar<InputStream> cache) {
        this.cache = cache;
    }

    @Override
    public InputStream stream() throws Exception {
        InputStream stream = cache.value();
        stream.reset();
        return stream;
    }
}

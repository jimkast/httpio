package org.jimkast.io;

import java.io.InputStream;
import org.cactoos.Input;
import org.cactoos.Scalar;
import org.cactoos.scalar.StickyScalar;

public final class InputWithCachedLength implements InputWithLength {
    private final InputWithLength origin;
    private final Scalar<Long> len;

    public InputWithCachedLength(Input input) {
        this(new InputWithLengthSimple(input));
    }

    public InputWithCachedLength(InputWithLength origin) {
        this.origin = origin;
        this.len = new StickyScalar<>(origin::size);
    }

    @Override
    public long size() throws Exception {
        return len.value();
    }

    @Override
    public InputStream stream() throws Exception {
        return origin.stream();
    }
}

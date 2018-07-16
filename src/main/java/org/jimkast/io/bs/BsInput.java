package org.jimkast.io.bs;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Input;
import org.cactoos.io.LengthOf;
import org.cactoos.io.OutputTo;
import org.cactoos.io.TeeInput;
import org.cactoos.scalar.IoCheckedScalar;
import org.jimkast.io.BytesSource;

public final class BsInput implements BytesSource {
    private final Input input;
    private final int size;

    public BsInput(Input input) {
        this(input, 8192);
    }

    public BsInput(Input input, int size) {
        this.input = input;
        this.size = size;
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        new IoCheckedScalar<>(new LengthOf(new TeeInput(input, new OutputTo(out)), size)).value();
        return this;
    }
}

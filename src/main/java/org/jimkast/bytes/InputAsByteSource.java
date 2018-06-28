package org.jimkast.bytes;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Input;
import org.cactoos.io.LengthOf;
import org.cactoos.io.OutputTo;
import org.cactoos.io.TeeInput;
import org.cactoos.scalar.IoCheckedScalar;

public final class InputAsByteSource implements BytesSource {
    private final Input input;
    private final int size;

    public InputAsByteSource(Input input, int size) {
        this.input = input;
        this.size = size;
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        new IoCheckedScalar<>(new LengthOf(new TeeInput(input, new OutputTo(out)), size)).value();
        return this;
    }
}

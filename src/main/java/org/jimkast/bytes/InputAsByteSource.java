package org.jimkast.bytes;

import java.io.IOException;
import java.io.OutputStream;
import org.cactoos.Input;
import org.cactoos.io.LengthOf;
import org.cactoos.io.OutputTo;
import org.cactoos.io.TeeInput;
import org.jimkast.io.BytesSource;

public final class InputAsByteSource implements BytesSource {
    private final Input input;
    private final int size;

    public InputAsByteSource(Input input) {
        this(input, 4096);
    }

    public InputAsByteSource(Input input, int size) {
        this.input = input;
        this.size = size;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        return new LengthOf(new TeeInput(input, new OutputTo(out)), size).longValue();
    }
}

package org.jimkast.io;

import java.io.InputStream;
import org.cactoos.Input;

public final class InputWithLengthSimple implements InputWithLength {
    private final Input input;

    public InputWithLengthSimple(Input input) {
        this.input = input;
    }

    @Override
    public long size() throws Exception {
        return input.stream().available();
    }

    @Override
    public InputStream stream() throws Exception {
        return input.stream();
    }
}

package org.jimkast.io;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.Input;

public final class InputIoChecked implements Input {
    private final Input input;

    public InputIoChecked(Input input) {
        this.input = input;
    }

    @Override
    public InputStream stream() throws IOException {
        try {
            return input.stream();
        } catch (RuntimeException | IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}

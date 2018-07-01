package org.jimkast.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import org.cactoos.Input;

public final class InputWithUnknownLength implements InputWithLength {
    private final Input input;
    private final List<Integer> cache = new ArrayList<>(1);

    public InputWithUnknownLength(Input input) {
        this.input = input;
    }

    @Override
    public long size() {
        if (cache.isEmpty()) {
            try {
                stream();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return cache.get(0);
    }

    @Override
    public InputStream stream() throws Exception {
        InputStream stream = input.stream();
        if (cache.isEmpty()) {
            cache.add(stream.available());
        }
        return stream;
    }
}

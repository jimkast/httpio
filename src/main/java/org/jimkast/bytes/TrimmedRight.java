package org.jimkast.bytes;

import java.io.IOException;
import java.io.Reader;
import org.jimkast.text.TextInput;

public final class TrimmedRight implements TextInput {
    private final TextInput origin;

    public TrimmedRight(TextInput origin) {
        this.origin = origin;
    }

    @Override
    public Reader stream() throws IOException {
        return origin.stream();
    }
}

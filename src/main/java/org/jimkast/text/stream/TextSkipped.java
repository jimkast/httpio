package org.jimkast.text.stream;

import java.io.IOException;
import java.io.Reader;
import org.jimkast.text.TextInput;

public final class TextSkipped implements TextInput {
    private final Number skip;
    private final TextInput origin;

    public TextSkipped(Number skip, TextInput origin) {
        this.skip = skip;
        this.origin = origin;
    }

    @Override
    public Reader stream() throws IOException {
        Reader stream = origin.stream();
        stream.skip(skip.intValue());
        return stream;
    }
}

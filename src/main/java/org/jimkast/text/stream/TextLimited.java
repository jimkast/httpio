package org.jimkast.text.stream;

import java.io.IOException;
import java.io.Reader;
import org.jimkast.text.TextInput;

public final class TextLimited implements TextInput {
    private final Number limit;
    private final TextInput origin;

    public TextLimited(Number limit, TextInput origin) {
        this.limit = limit;
        this.origin = origin;
    }

    @Override
    public Reader stream() throws IOException {
        return new ReaderLimited(limit, origin.stream());
    }
}

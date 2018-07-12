package org.jimkast.bytes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import org.jimkast.text.TextInput;

public final class TrimmedLeft implements TextInput {
    private final TextInput origin;

    public TrimmedLeft(TextInput origin) {
        this.origin = origin;
    }

    @Override
    public Reader stream() throws IOException {
        Reader stream = new BufferedReader(origin.stream(), 1);
        int ch;
        do {
            ch = stream.read();
            stream.mark(1);
        } while (ch != -1 && Character.isWhitespace(ch));
        stream.reset();
        return stream;
    }
}

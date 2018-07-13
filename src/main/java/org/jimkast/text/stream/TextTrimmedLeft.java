package org.jimkast.text.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import org.jimkast.text.TextInput;

public final class TextTrimmedLeft implements TextInput {
    private final TextInput origin;

    public TextTrimmedLeft(TextInput origin) {
        this.origin = origin;
    }

    @Override
    public Reader stream() throws IOException {
        Reader stream = new BufferedReader(origin.stream(), 16);
        int ch;
        do {
            stream.mark(1);
            ch = stream.read();
        } while (ch != -1 && Character.isWhitespace(ch));
        stream.reset();
        return stream;
    }
}

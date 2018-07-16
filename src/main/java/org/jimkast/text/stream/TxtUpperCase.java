package org.jimkast.text.stream;

import java.io.IOException;
import java.io.Writer;
import org.jimkast.text.TextSource;

public final class TxtUpperCase implements TextSource {
    private final TextSource source;

    public TxtUpperCase(TextSource source) {
        this.source = source;
    }

    @Override
    public TextSource print(Writer out) throws IOException {
        return source.print(new WriterUpperCase(out));
    }
}

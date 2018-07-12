package org.jimkast.text;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;

public interface TextInput {
    Reader stream() throws IOException;


    class Envelope implements TextInput {
        private final TextInput origin;

        public Envelope(TextInput origin) {
            this.origin = origin;
        }

        @Override
        public final Reader stream() throws IOException {
            return origin.stream();
        }
    }

    final class Unchecked implements TextInput {
        private final TextInput origin;

        public Unchecked(TextInput origin) {
            this.origin = origin;
        }

        @Override
        public Reader stream() {
            try {
                return origin.stream();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}

package org.jimkast.v2;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.Input;

public interface HttpIn extends Input {
    HttpHead head();

    @Override
    InputStream stream() throws IOException;


    class Envelope implements HttpIn {
        private final HttpIn origin;

        public Envelope(HttpIn origin) {
            this.origin = origin;
        }

        @Override
        public final HttpHead head() {
            return origin.head();
        }

        @Override
        public final InputStream stream() throws IOException {
            return origin.stream();
        }
    }
}

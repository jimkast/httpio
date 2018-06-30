package org.jimkast.http;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.Input;

public interface HttpIn extends HttpHead, Input {
    @Override
    String line();

    @Override
    Iterable<String> headers();

    @Override
    InputStream stream() throws IOException;


    class Envelope implements HttpIn {
        private final HttpIn origin;

        public Envelope(HttpIn origin) {
            this.origin = origin;
        }

        @Override
        public String line() {
            return origin.line();
        }

        @Override
        public Iterable<String> headers() {
            return origin.headers();
        }

        @Override
        public final InputStream stream() throws IOException {
            return origin.stream();
        }
    }
}

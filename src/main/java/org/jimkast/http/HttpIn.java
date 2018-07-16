package org.jimkast.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.cactoos.Input;

public interface HttpIn extends HttpHead, Input {
    @Override
    List<String> line();

    @Override
    Iterable<Header> headers();

    @Override
    InputStream stream() throws IOException;


    class Envelope implements HttpIn {
        private final HttpIn origin;

        public Envelope(HttpIn origin) {
            this.origin = origin;
        }

        @Override
        public List<String> line() {
            return origin.line();
        }

        @Override
        public Iterable<Header> headers() {
            return origin.headers();
        }

        @Override
        public final InputStream stream() throws IOException {
            return origin.stream();
        }
    }
}

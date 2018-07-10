package org.jimkast.http;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.io.BytesSource;

public interface HttpOut extends HttpHead, BytesSource {
    @Override
    Iterable<String> line();

    @Override
    Iterable<Header> headers();

    @Override
    long print(OutputStream out) throws IOException;


    class Envelope implements HttpOut {
        private final HttpOut origin;

        public Envelope(HttpOut origin) {
            this.origin = origin;
        }

        @Override
        public final Iterable<String> line() {
            return origin.line();
        }

        @Override
        public final Iterable<Header> headers() {
            return origin.headers();
        }

        @Override
        public final long print(OutputStream out) throws IOException {
            return origin.print(out);
        }
    }
}

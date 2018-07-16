package org.jimkast.http;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.jimkast.io.BytesSource;

public interface HttpOut extends HttpHead, BytesSource {
    @Override
    List<String> line();

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
        public final List<String> line() {
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

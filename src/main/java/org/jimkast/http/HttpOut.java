package org.jimkast.http;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.io.BytesSource;
import org.jimkast.map.Prop;

public interface HttpOut extends HttpHead, BytesSource {
    @Override
    HttpLine line();

    @Override
    Iterable<Prop> headers();

    @Override
    BytesSource print(OutputStream out) throws IOException;


    class Envelope implements HttpOut {
        private final HttpOut origin;

        public Envelope(HttpOut origin) {
            this.origin = origin;
        }

        @Override
        public final HttpLine line() {
            return origin.line();
        }

        @Override
        public final Iterable<Prop> headers() {
            return origin.headers();
        }

        @Override
        public final BytesSource print(OutputStream out) throws IOException {
            return origin.print(out);
        }
    }
}

package org.jimkast.v2;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.bytes.BytesSource;

public interface HttpOut extends BytesSource {
    HttpHead head();

    @Override
    long print(OutputStream out) throws IOException;


    class Envelope implements HttpOut {
        private final HttpOut origin;

        public Envelope(HttpOut origin) {
            this.origin = origin;
        }

        @Override
        public final HttpHead head() {
            return origin.head();
        }

        @Override
        public long print(OutputStream out) throws IOException {
            return origin.print(out);
        }
    }
}

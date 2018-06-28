package org.jimkast.bytes;

import java.io.IOException;
import java.io.OutputStream;

public interface BytesSource {
    BytesSource print(OutputStream out) throws IOException;


    class Envelope implements BytesSource {
        private final BytesSource origin;

        public Envelope(BytesSource origin) {
            this.origin = origin;
        }

        @Override
        public final BytesSource print(OutputStream out) throws IOException {
            return origin.print(out);
        }
    }
}

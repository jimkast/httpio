package org.jimkast.io;

import java.io.IOException;
import java.io.OutputStream;

public interface BytesSource {
    BytesSource print(OutputStream out) throws IOException;


    BytesSource EMPTY = new BytesSource() {
        @Override
        public BytesSource print(OutputStream out) {
            return this;
        }
    };


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

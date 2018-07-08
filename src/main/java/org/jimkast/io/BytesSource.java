package org.jimkast.io;

import java.io.IOException;
import java.io.OutputStream;

public interface BytesSource {
    long print(OutputStream out) throws IOException;


    BytesSource EMPTY = out -> 0;


    class Envelope implements BytesSource {
        private final BytesSource origin;

        public Envelope(BytesSource origin) {
            this.origin = origin;
        }

        @Override
        public final long print(OutputStream out) throws IOException {
            return origin.print(out);
        }
    }
}
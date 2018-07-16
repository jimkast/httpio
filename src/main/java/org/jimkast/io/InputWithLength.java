package org.jimkast.io;

import java.io.InputStream;
import org.cactoos.Input;

public interface InputWithLength extends Input {
    long size() throws Exception;

    @Override
    InputStream stream() throws Exception;


    class Envelope implements InputWithLength {
        private final InputWithLength origin;

        public Envelope(InputWithLength origin) {
            this.origin = origin;
        }

        @Override
        public final long size() throws Exception {
            return origin.size();
        }

        @Override
        public final InputStream stream() throws Exception {
            return origin.stream();
        }
    }


    final class Known implements InputWithLength {
        private final Number length;
        private final Input input;

        public Known(Number length, Input input) {
            this.length = length;
            this.input = input;
        }

        @Override
        public long size() throws Exception {
            return length.longValue();
        }

        @Override
        public InputStream stream() throws Exception {
            return input.stream();
        }
    }
}

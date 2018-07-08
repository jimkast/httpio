package org.jimkast.opt;


import java.util.NoSuchElementException;
import org.cactoos.Scalar;

public interface Possible<T> extends Scalar<T> {
    boolean exists();

    @Override
    T value() throws Exception;


    class Envelope<T> implements Possible<T> {
        private final Possible<T> origin;

        public Envelope(Possible<T> origin) {
            this.origin = origin;
        }

        @Override
        public final boolean exists() {
            return origin.exists();
        }

        @Override
        public final T value() throws Exception {
            return origin.value();
        }
    }

    final class Full<T> implements Possible<T> {
        private final T value;

        public Full(T value) {
            this.value = value;
        }

        @Override
        public boolean exists() {
            return true;
        }

        @Override
        public T value() {
            return value;
        }
    }


    final class Empty<T> implements Possible<T> {
        @Override
        public boolean exists() {
            return false;
        }

        @Override
        public T value() {
            throw new NoSuchElementException("Empty Opt envelope.");
        }
    }

}

package org.jimkast.iterable;

import java.util.AbstractList;

public interface Array<T> {
    int length();

    T get(int i);


    class Envelope<T> implements Array<T> {
        private final Array<T> origin;

        public Envelope(Array<T> origin) {
            this.origin = origin;
        }

        @Override
        public final int length() {
            return origin.length();
        }

        @Override
        public final T get(int i) {
            return origin.get(i);
        }
    }


    final class ArrayAsList<T> extends AbstractList<T> {
        private final Array<T> array;

        public ArrayAsList(Array<T> array) {
            this.array = array;
        }

        @Override
        public T get(int i) {
            return array.get(i);
        }

        @Override
        public int size() {
            return array.length();
        }
    }
}

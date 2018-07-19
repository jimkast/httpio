package org.jimkast.iterable;

import java.util.Iterator;
import java.util.function.BiFunction;

public final class MappedWithIndex<X, Y> implements Iterable<Y> {
    private final BiFunction<X, Integer, Y> mapper;
    private final Iterable<X> origin;

    public MappedWithIndex(BiFunction<X, Integer, Y> mapper, Iterable<X> origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public Iterator<Y> iterator() {
        return new MappedWithIndexIter<>(mapper, origin.iterator());
    }

    
    public static final class MappedWithIndexIter<X, Y> implements Iterator<Y> {
        private final BiFunction<X, Integer, Y> mapper;
        private final Iterator<X> origin;
        private int i = 0;

        public MappedWithIndexIter(BiFunction<X, Integer, Y> mapper, Iterator<X> origin) {
            this.mapper = mapper;
            this.origin = origin;
        }

        @Override
        public boolean hasNext() {
            return origin.hasNext();
        }

        @Override
        public Y next() {
            return mapper.apply(origin.next(), i++);
        }
    }
}

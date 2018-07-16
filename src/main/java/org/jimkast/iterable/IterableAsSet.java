package org.jimkast.iterable;

import java.util.AbstractSet;
import java.util.Iterator;
import org.cactoos.iterable.LengthOf;

public final class IterableAsSet<T> extends AbstractSet<T> {
    private final Iterable<T> iterable;

    public IterableAsSet(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return iterable.iterator();
    }

    @Override
    public int size() {
        return new LengthOf(iterable).intValue();
    }
}

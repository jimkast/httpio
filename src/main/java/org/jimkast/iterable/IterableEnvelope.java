package org.jimkast.iterable;

import java.util.Iterator;

public class IterableEnvelope<T> implements Iterable<T> {
    private final Iterable<T> origin;

    public IterableEnvelope(Iterable<T> origin) {
        this.origin = origin;
    }

    @Override
    public final Iterator<T> iterator() {
        return origin.iterator();
    }
}

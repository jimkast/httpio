package org.jimkast.iterable;

import java.util.Iterator;

public interface IterableWithLength<T> extends Iterable<T> {
    int size();

    @Override
    Iterator<T> iterator();
}

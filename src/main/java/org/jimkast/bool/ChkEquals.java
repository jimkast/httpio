package org.jimkast.bool;

import java.util.function.Predicate;

public final class ChkEquals<T> implements Predicate<T> {
    private final T comp;

    public ChkEquals(T comp) {
        this.comp = comp;
    }

    @Override
    public boolean test(T t) {
        return comp.equals(t);
    }
}

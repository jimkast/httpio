package org.jimkast.util.bool;

import java.util.function.Predicate;

public final class MatchEquals<T> implements Predicate<T> {
    private final T comp;

    public MatchEquals(T comp) {
        this.comp = comp;
    }

    @Override
    public boolean test(T t) {
        return comp.equals(t);
    }
}

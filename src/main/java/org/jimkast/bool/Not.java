package org.jimkast.bool;

import java.util.function.Predicate;

public final class Not<T> implements Predicate<T> {
    private final Predicate<T> origin;

    public Not(Predicate<T> origin) {
        this.origin = origin;
    }

    @Override
    public boolean test(T t) {
        return !origin.test(t);
    }
}

package org.jimkast.util.bool;

import java.util.Arrays;
import java.util.function.Predicate;

public final class And<T> implements Predicate<T> {
    private final Iterable<Predicate<T>> all;

    @SafeVarargs
    public And(Predicate<T>... all) {
        this(Arrays.asList(all));
    }

    public And(Iterable<Predicate<T>> all) {
        this.all = all;
    }

    @Override
    public boolean test(T t) {
        for (Predicate<T> check : all) {
            if (!check.test(t)) {
                return false;
            }
        }
        return true;
    }
}

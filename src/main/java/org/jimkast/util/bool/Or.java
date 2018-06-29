package org.jimkast.util.bool;

import java.util.Arrays;
import java.util.function.Predicate;

public final class Or<T> implements Predicate<T> {
    private final Iterable<Predicate<T>> all;

    @SafeVarargs
    public Or(Predicate<T>... all) {
        this(Arrays.asList(all));
    }

    public Or(Iterable<Predicate<T>> all) {
        this.all = all;
    }

    @Override
    public boolean test(T t) {
        for (Predicate<T> check : all) {
            if (check.test(t)) {
                return true;
            }
        }
        return false;
    }
}

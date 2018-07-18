package org.jimkast.bool;

import java.util.Arrays;
import java.util.function.Predicate;
import org.cactoos.Scalar;

public final class BoolFromPredicate<T> implements Scalar<Boolean> {
    private final Predicate<Iterable<T>> check;
    private final Iterable<T> items;

    public BoolFromPredicate(Predicate<Iterable<T>> check, T... items) {
        this(check, Arrays.asList(items));
    }

    public BoolFromPredicate(Predicate<Iterable<T>> check, Iterable<T> items) {
        this.check = check;
        this.items = items;
    }

    @Override
    public Boolean value() throws Exception {
        return check.test(items);
    }
}

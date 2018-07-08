package org.jimkast.bool;

import java.util.function.Predicate;

public class PredicateEnvelope<T> implements Predicate<T> {
    private final Predicate<T> origin;

    public PredicateEnvelope(Predicate<T> origin) {
        this.origin = origin;
    }

    @Override
    public final boolean test(T t) {
        return origin.test(t);
    }
}

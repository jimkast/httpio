package org.jimkast.bool;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public final class ChkMatchAny<T> implements Predicate<Iterable<T>> {
    private final Predicate<T> check;

    @SafeVarargs
    public ChkMatchAny(T... available) {
        this(Arrays.asList(available));
    }

    public ChkMatchAny(Collection<T> available) {
        this(available::contains);
    }

    public ChkMatchAny(Predicate<T> check) {
        this.check = check;
    }

    @Override
    public boolean test(Iterable<T> all) {
        for (T t : all) {
            if(check.test(t)) {
                return true;
            }
        }
        return false;
    }
}

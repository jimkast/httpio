package org.jimkast.bool;

import java.util.function.Predicate;

public final class ChkMatchAll<T> implements Predicate<Iterable<T>> {
    private final Predicate<T> check;

    public ChkMatchAll(Predicate<T> check) {
        this.check = check;
    }

    @Override
    public boolean test(Iterable<T> all) {
        for (T t : all) {
            if(!check.test(t)) {
                return false;
            }
        }
        return true;
    }
}

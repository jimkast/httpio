package org.jimkast.bool;

import java.util.function.Predicate;
import org.cactoos.Scalar;

public final class AllMatch<T> implements Scalar<Boolean> {
    private final Predicate<T> check;
    private final Iterable<T> iterable;

    public AllMatch(Predicate<T> check, Iterable<T> iterable) {
        this.check = check;
        this.iterable = iterable;
    }

    @Override
    public Boolean value() {
        for (T t : iterable) {
            if(!check.test(t)) {
                return false;
            }
        }
        return true;
    }
}

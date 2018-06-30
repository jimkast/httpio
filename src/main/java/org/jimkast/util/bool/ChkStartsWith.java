package org.jimkast.util.bool;

import java.util.function.Predicate;

public final class ChkStartsWith implements Predicate<String> {
    private final CharSequence start;

    public ChkStartsWith(CharSequence start) {
        this.start = start;
    }

    @Override
    public boolean test(String s) {
        return s.startsWith(start.toString());
    }
}

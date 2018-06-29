package org.jimkast.util.bool;

import java.util.function.Predicate;

public final class MatchStartsWith implements Predicate<String> {
    private final CharSequence start;

    public MatchStartsWith(CharSequence start) {
        this.start = start;
    }

    @Override
    public boolean test(String s) {
        return s.startsWith(start.toString());
    }
}

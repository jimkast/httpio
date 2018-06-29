package org.jimkast.util.bool;

import java.util.function.Predicate;

public final class MatchEqualsIgnoreCase implements Predicate<String> {
    private final CharSequence comp;

    public MatchEqualsIgnoreCase(CharSequence comp) {
        this.comp = comp;
    }

    @Override
    public boolean test(String s) {
        return s.equalsIgnoreCase(comp.toString());
    }
}

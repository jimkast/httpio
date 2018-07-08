package org.jimkast.bool;

import java.util.function.Predicate;

public final class ChkEqualsIgnoreCase implements Predicate<String> {
    private final CharSequence comp;

    public ChkEqualsIgnoreCase(CharSequence comp) {
        this.comp = comp;
    }

    @Override
    public boolean test(String s) {
        return s.equalsIgnoreCase(comp.toString());
    }
}

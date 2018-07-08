package org.jimkast.bool;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class ChkRegex implements Predicate<String> {
    private final Pattern ptn;

    public ChkRegex(String ptn) {
        this(Pattern.compile(ptn));
    }

    public ChkRegex(Pattern ptn) {
        this.ptn = ptn;
    }

    @Override
    public boolean test(String charSequence) {
        return ptn.matcher(charSequence).matches();
    }
}

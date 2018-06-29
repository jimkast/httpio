package org.jimkast.util.bool;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class RegexMatchAll implements Predicate<String> {
    private final Pattern ptn;

    public RegexMatchAll(String ptn) {
        this(Pattern.compile(ptn));
    }

    public RegexMatchAll(Pattern ptn) {
        this.ptn = ptn;
    }

    @Override
    public boolean test(String charSequence) {
        return ptn.matcher(charSequence).matches();
    }
}

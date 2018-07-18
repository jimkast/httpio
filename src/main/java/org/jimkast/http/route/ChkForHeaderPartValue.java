package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.http.HeaderPart;

public final class ChkForHeaderPartValue implements Predicate<HeaderPart> {
    private final Predicate<String> check;

    public ChkForHeaderPartValue(CharSequence value) {
        this(new ChkEqualsIgnoreCase(value));
    }

    public ChkForHeaderPartValue(Predicate<String> check) {
        this.check = check;
    }

    @Override
    public boolean test(HeaderPart part) {
        return check.test(part.value());
    }
}

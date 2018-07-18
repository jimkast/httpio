package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.bool.ChkMatchAny;
import org.jimkast.http.parse.HeaderInnerValues;

public final class ChkHeaderInnerValue implements Predicate<String> {
    private final Predicate<String> check;

    public ChkHeaderInnerValue(CharSequence value) {
        this(new ChkEqualsIgnoreCase(value));
    }

    public ChkHeaderInnerValue(Predicate<String> check) {
        this.check = check;
    }

    @Override
    public boolean test(String value) {
        return new ChkMatchAny<>(check).test(new HeaderInnerValues(value));
    }
}

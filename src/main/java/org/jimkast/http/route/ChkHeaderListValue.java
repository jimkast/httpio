package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.bool.ChkMatchAny;
import org.jimkast.http.parse.HeaderListValues;

public final class ChkHeaderListValue implements Predicate<String> {
    private final Predicate<String> check;

    public ChkHeaderListValue(CharSequence value) {
        this(new ChkEqualsIgnoreCase(value));
    }

    public ChkHeaderListValue(Predicate<String> check) {
        this.check = check;
    }

    @Override
    public boolean test(String value) {
        return new ChkMatchAny<>(check).test(new HeaderListValues(value));
    }
}

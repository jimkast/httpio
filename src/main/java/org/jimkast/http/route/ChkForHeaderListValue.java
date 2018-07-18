package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.bool.PredicateEnvelope;

public final class ChkForHeaderListValue extends PredicateEnvelope<String> {
    public ChkForHeaderListValue(CharSequence value) {
        this(new ChkEqualsIgnoreCase(value));
    }

    public ChkForHeaderListValue(Predicate<String> check) {
        super(new ChkHeaderListValue(check));
    }
}

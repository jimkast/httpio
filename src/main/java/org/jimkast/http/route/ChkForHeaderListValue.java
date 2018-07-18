package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.bool.PredicateEnvelope;
import org.jimkast.http.HttpHead;

public final class ChkForHeaderListValue extends PredicateEnvelope<HttpHead> {
    public ChkForHeaderListValue(CharSequence name, CharSequence value) {
        this(name, new ChkEqualsIgnoreCase(value));
    }

    public ChkForHeaderListValue(CharSequence name, Predicate<String> check) {
        super(new ChkForHeader(name, new ChkHeaderListValue(check)));
    }
}

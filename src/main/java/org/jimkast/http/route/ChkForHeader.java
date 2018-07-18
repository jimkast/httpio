package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.http.HttpHead;
import org.jimkast.http.parse.header.HttpHeaderValue;

public final class ChkForHeader implements Predicate<HttpHead> {
    private final CharSequence name;
    private final Predicate<String> match;

    public ChkForHeader(CharSequence name, CharSequence match) {
        this(name, new ChkEqualsIgnoreCase(match));
    }

    public ChkForHeader(CharSequence name, Predicate<String> match) {
        this.name = name;
        this.match = match;
    }

    @Override
    public boolean test(HttpHead head) {
        return match.test(new HttpHeaderValue(head, name.toString()).toString());
    }
}

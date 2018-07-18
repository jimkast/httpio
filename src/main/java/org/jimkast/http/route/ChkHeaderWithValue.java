package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.http.HttpHead;
import org.jimkast.http.parse.HttpHeaderValue;

public final class ChkHeaderWithValue implements Predicate<HttpHead> {
    private final CharSequence name;
    private final CharSequence value;

    public ChkHeaderWithValue(CharSequence name, CharSequence value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean test(HttpHead head) {
        return value.toString().equalsIgnoreCase(new HttpHeaderValue(head, name).toString());
    }
}

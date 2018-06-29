package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.http.HttpHead;

public final class ChkMethod implements Predicate<HttpHead> {
    private final CharSequence method;

    public ChkMethod(CharSequence method) {
        this.method = method;
    }

    @Override
    public boolean test(HttpHead head) {
        return head.line().startsWith(method.toString() + " ");
    }
}

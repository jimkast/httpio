package org.jimkast.http.route;

import java.util.Arrays;
import java.util.function.Predicate;
import org.jimkast.bool.ChkMatchAny;
import org.jimkast.http.HttpHead;
import org.jimkast.http.parse.line.RqMethod;

public final class ChkForMethod implements Predicate<HttpHead> {
    private final Predicate<String> check;

    public ChkForMethod(String... methods) {
        this(Arrays.asList(methods));
    }

    public ChkForMethod(Iterable<String> methods) {
        this(s -> new ChkMatchAny<>(s).test(methods));
    }

    public ChkForMethod(Predicate<String> check) {
        this.check = check;
    }

    @Override
    public boolean test(HttpHead head) {
        return check.test(new RqMethod(head).toString());
    }
}

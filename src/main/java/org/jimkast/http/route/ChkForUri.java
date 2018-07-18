package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.http.HttpHead;
import org.jimkast.http.parse.RqURI;

public final class ChkForUri implements Predicate<HttpHead> {
    private final Predicate<String> match;

    public ChkForUri() {
        this(new ChkEqualsIgnoreCase("/"));
    }

    public ChkForUri(Predicate<String> match) {
        this.match = match;
    }

    @Override
    public boolean test(HttpHead head) {
        return match.test(new RqURI(head).toString());
    }
}

package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.util.bool.MatchEqualsIgnoreCase;
import org.jimkast.http.HttpHead;
import org.jimkast.http.rq.RqUri;

public final class ChkUri implements Predicate<HttpHead> {
    private final Predicate<String> match;

    public ChkUri() {
        this(new MatchEqualsIgnoreCase("/"));
    }

    public ChkUri(Predicate<String> match) {
        this.match = match;
    }

    @Override
    public boolean test(HttpHead head) {
        return match.test(new RqUri(head).toString());
    }
}

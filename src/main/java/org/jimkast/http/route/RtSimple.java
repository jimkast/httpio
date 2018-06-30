package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RtSimple implements HttpRoute {
    private final Predicate<HttpHead> check;
    private final HttpServerMapping mapping;

    public RtSimple(Predicate<HttpHead> check, HttpServerMapping mapping) {
        this.check = check;
        this.mapping = mapping;
    }


    @Override
    public boolean test(HttpHead head) {
        return check.test(head);
    }

    @Override
    public HttpServerMapping map() {
        return mapping;
    }
}

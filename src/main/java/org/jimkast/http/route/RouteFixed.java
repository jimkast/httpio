package org.jimkast.http.route;

import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RouteFixed implements HttpRoute{
    private final HttpServerMapping mapping;

    public RouteFixed(HttpServerMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public boolean test(HttpHead head) {
        return true;
    }

    @Override
    public HttpServerMapping map() {
        return mapping;
    }
}

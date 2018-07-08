package org.jimkast.http.route;

import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RtFixed implements HttpRoute {
    private final HttpServerMapping mapping;

    public RtFixed(HttpServerMapping mapping) {
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

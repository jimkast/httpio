package org.jimkast.http.route;

import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.tk.TkFixed;

public final class RtFixed implements HttpRoute {
    private final HttpServerMapping mapping;

    public RtFixed(HttpOut res) {
        this(new TkFixed(res));
    }

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

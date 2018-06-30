package org.jimkast.http.route;

import java.util.Arrays;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class TkRoute implements HttpServerMapping {
    private final HttpServerMapping Default;
    private final Iterable<HttpRoute> routes;

    public TkRoute(HttpRoute... routes) {
        this(new TkNotFound(), Arrays.asList(routes));
    }

    public TkRoute(HttpServerMapping Default, HttpRoute... routes) {
        this(Default, Arrays.asList(routes));
    }

    public TkRoute(HttpServerMapping Default, Iterable<HttpRoute> routes) {
        this.Default = Default;
        this.routes = routes;
    }

    @Override
    public HttpOut exchange(HttpIn in) {
        for (HttpRoute route : routes) {
            if(route.test(in)) {
                return route.map().exchange(in);
            }
        }
        return Default.exchange(in);
    }
}

package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RouteUri extends HttpRoute.Envelope {
    public RouteUri(Predicate<String> uriCheck, HttpServerMapping mapping) {
        super(
            new RouteSimple(
                new ChkUri(uriCheck),
                mapping
            )
        );
    }
}

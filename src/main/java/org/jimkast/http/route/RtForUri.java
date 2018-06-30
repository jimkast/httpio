package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RtForUri extends HttpRoute.Envelope {
    public RtForUri(Predicate<String> uriCheck, HttpServerMapping mapping) {
        super(
            new RtSimple(
                new ChkForUri(uriCheck),
                mapping
            )
        );
    }
}

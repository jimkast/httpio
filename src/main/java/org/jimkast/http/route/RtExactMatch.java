package org.jimkast.http.route;

import org.jimkast.bool.ChkEquals;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RtExactMatch extends HttpRoute.Envelope {

    public RtExactMatch(String uri, HttpServerMapping mapping) {
        super(
            new RtForUri(
                new ChkEquals<>(uri),
                mapping
            )
        );
    }
}

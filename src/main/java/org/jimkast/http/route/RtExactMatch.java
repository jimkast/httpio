package org.jimkast.http.route;

import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.bool.ChkEqualsIgnoreCase;

public final class RtExactMatch extends HttpRoute.Envelope {

    public RtExactMatch(String uri, HttpServerMapping mapping) {
        super(
            new RtForUri(
                new ChkEqualsIgnoreCase(uri),
                mapping
            )
        );
    }
}

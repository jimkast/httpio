package org.jimkast.http.route;

import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.util.bool.ChkEqualsIgnoreCase;

public final class FkExactMatch extends HttpRoute.Envelope {

    public FkExactMatch(String uri, HttpServerMapping mapping) {
        super(
            new RtForUri(
                new ChkEqualsIgnoreCase(uri),
                mapping
            )
        );
    }
}

package org.jimkast.http.route;

import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RtCaseMatch extends HttpRoute.Envelope {

    public RtCaseMatch(CharSequence uri, HttpServerMapping mapping) {
        super(
            new RtForUri(
                new ChkEqualsIgnoreCase(uri),
                mapping
            )
        );
    }
}

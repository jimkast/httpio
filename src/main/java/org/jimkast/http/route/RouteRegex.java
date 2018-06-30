package org.jimkast.http.route;

import java.util.regex.Pattern;
import org.jimkast.util.bool.ChkRegex;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RouteRegex extends HttpRoute.Envelope {
    public RouteRegex(String pattern, HttpServerMapping mapping) {
        this(Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL), mapping);
    }

    public RouteRegex(Pattern pattern, HttpServerMapping mapping) {
        super(
            new RouteUri(
                new ChkRegex(pattern),
                mapping
            )
        );
    }
}

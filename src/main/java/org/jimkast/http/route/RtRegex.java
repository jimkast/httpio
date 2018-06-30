package org.jimkast.http.route;

import java.util.regex.Pattern;
import org.jimkast.util.bool.ChkRegex;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class RtRegex extends HttpRoute.Envelope {
    public RtRegex(String pattern, HttpServerMapping mapping) {
        this(Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.DOTALL), mapping);
    }

    public RtRegex(Pattern pattern, HttpServerMapping mapping) {
        super(
            new RtForUri(
                new ChkRegex(pattern),
                mapping
            )
        );
    }
}

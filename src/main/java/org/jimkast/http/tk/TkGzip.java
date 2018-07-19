package org.jimkast.http.tk;

import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.route.ChkEncoding;
import org.jimkast.http.route.RtFixed;
import org.jimkast.http.route.RtSimple;
import org.jimkast.http.route.TkRoute;
import org.jimkast.http.rs.RsGzip;

public final class TkGzip extends HttpServerMapping.Envelope {
    public TkGzip(HttpServerMapping origin) {
        super(
            new TkRoute(
                new RtSimple(
                    new ChkEncoding("gzip"),
                    in -> new RsGzip(origin.exchange(in))
                ),
                new RtFixed(origin)
            )
        );
    }
}

package org.jimkast.http.rs;

import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.http.head.RsEmpty;

public final class RsWithHeaders extends HttpOut.Envelope {
    public RsWithHeaders(CharSequence... headers) {
        this(new RsEmpty(), headers);
    }

    public RsWithHeaders(HttpOut origin, CharSequence... headers) {
        super(new RsBasic(new HeadWithHeaders(origin, headers), origin));
    }

    public RsWithHeaders(Iterable<String> headers) {
        this(new RsEmpty(), headers);
    }

    public RsWithHeaders(HttpOut origin, Iterable<String> headers) {
        super(new RsBasic(new HeadWithHeaders(origin, headers), origin));
    }
}

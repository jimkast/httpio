package org.jimkast.http.rs;

import org.jimkast.http.Header;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeaders;

public final class RsWithHeaders extends HttpOut.Envelope {
    public RsWithHeaders(CharSequence... headers) {
        this(new RsEmpty(), headers);
    }

    public RsWithHeaders(HttpOut origin, CharSequence... headers) {
        super(new RsBasic(new HeadWithHeaders(origin, headers), origin));
    }

    public RsWithHeaders(Iterable<String> headers) {
        super(new RsBasic(new HeadWithHeaders(headers)));
    }

    public RsWithHeaders(HttpOut origin, Iterable<Header> headers) {
        super(new RsBasic(new HeadWithHeaders(origin, headers), origin));
    }
}

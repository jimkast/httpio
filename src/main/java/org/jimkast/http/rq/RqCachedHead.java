package org.jimkast.http.rq;

import org.jimkast.http.HttpIn;
import org.jimkast.http.head.HeadSticky;

public final class RqCachedHead extends HttpIn.Envelope {
    public RqCachedHead(HttpIn origin) {
        super(
            new RqBasic(
                new HeadSticky(origin),
                origin
            )
        );
    }
}

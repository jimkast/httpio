package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;
import org.jimkast.text.TextNextIfEmpty;

public final class RqIP extends TextEnvelope {
    public RqIP(HttpHead req) {
        super(
            new TextNextIfEmpty(
                new HttpHeaderValue(req, "X-Forwarded-For"),
                new RqRemoteAddr(req)
            )
        );
    }
}
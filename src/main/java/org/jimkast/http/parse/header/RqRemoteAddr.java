package org.jimkast.http.parse.header;

import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RqRemoteAddr extends TextEnvelope {
    public RqRemoteAddr(HttpHead req) {
        super(new HttpHeaderValue(req, "X-Meta-RemoteAddress"));
    }
}
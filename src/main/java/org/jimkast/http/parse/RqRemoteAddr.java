package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RqRemoteAddr extends TextEnvelope {
    public RqRemoteAddr(HttpHead req) {
        super(new HttpHeaderValue(req, "X-Takes-RemoteAddress"));
    }
}
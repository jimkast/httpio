package org.jimkast.http.parse.line;

import org.jimkast.http.HttpHead;
import org.jimkast.http.parse.header.HttpHeaderValue;
import org.jimkast.text.Concat;
import org.jimkast.text.TextEnvelope;

public final class RqURL extends TextEnvelope {
    public RqURL(HttpHead req) {
        super(new Concat("http://", new HttpHeaderValue(req, "Host"), new RqURI(req)));
    }
}

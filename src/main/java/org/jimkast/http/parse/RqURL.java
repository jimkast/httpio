package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.text.Concat;
import org.jimkast.text.TextEnvelope;

public final class RqURL extends TextEnvelope {
    public RqURL(HttpHead req) {
        super(new Concat("http://", new RqHeaderValue(req, "Host"), new RqURI(req)));
    }
}

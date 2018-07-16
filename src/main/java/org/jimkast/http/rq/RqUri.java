package org.jimkast.http.rq;

import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RqUri extends TextEnvelope {
    public RqUri(HttpHead head) {
        super(() -> head.line().get(1));
    }
}

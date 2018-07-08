package org.jimkast.http.rq;

import org.jimkast.text.TextEnvelope;
import org.jimkast.http.HttpHead;

public final class RqUri extends TextEnvelope {
    public RqUri(HttpHead head) {
        this(new TextEnvelope(head::line));
    }

    public RqUri(CharSequence str) {
        super(() -> str.toString().split("\\s+", 3)[1]);
    }
}

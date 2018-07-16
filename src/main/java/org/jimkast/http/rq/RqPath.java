package org.jimkast.http.rq;

import org.jimkast.http.HttpHead;
import org.jimkast.text.SubstringBefore;
import org.jimkast.text.TextEnvelope;

public final class RqPath extends TextEnvelope {
    public RqPath(HttpHead head) {
        this(new RqUri(head));
    }

    public RqPath(CharSequence str) {
        super(new SubstringBefore(str, "?", str));
    }
}

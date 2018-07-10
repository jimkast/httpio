package org.jimkast.http.rq;

import org.cactoos.scalar.ItemAt;
import org.jimkast.http.head.HeadLineParts;
import org.jimkast.text.TextEnvelope;
import org.jimkast.http.HttpHead;

public final class RqUri extends TextEnvelope {
    public RqUri(HttpHead head) {
        this(new HeadLineParts(head));
    }

    public RqUri(Iterable<String> str) {
        super(new ItemAt<>(1, str));
    }
}

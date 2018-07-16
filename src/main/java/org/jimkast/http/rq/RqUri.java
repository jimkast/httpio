package org.jimkast.http.rq;

import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RqUri extends TextEnvelope {
    public RqUri(HttpHead head) {
        super(new ItemAt<>(1, () -> head.line().iterator()));
    }
}

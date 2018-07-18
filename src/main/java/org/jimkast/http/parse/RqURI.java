package org.jimkast.http.parse;

import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RqURI extends TextEnvelope {
    public RqURI(HttpHead head) {
        super(new ItemAt<>(1, () -> head.line().iterator()));
    }
}

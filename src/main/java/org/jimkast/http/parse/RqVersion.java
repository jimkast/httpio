package org.jimkast.http.parse;

import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RqVersion extends TextEnvelope {
    public RqVersion(HttpHead head) {
        this(new HttpHead.LineParts(head));
    }

    public RqVersion(Iterable<String> line) {
        super(new ItemAt<>(2, line));
    }
}

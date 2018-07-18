package org.jimkast.http.parse;

import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RqURI extends TextEnvelope {
    public RqURI(HttpHead head) {
        this(new HttpHead.LineParts(head));
    }

    public RqURI(Iterable<String> line) {
        super(new ItemAt<>(1, line));
    }
}

package org.jimkast.http.parse.line;

import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RqMethod extends TextEnvelope {
    public RqMethod(HttpHead head) {
        this(new HttpHead.LineParts(head));
    }

    public RqMethod(Iterable<String> line) {
        super(new ItemAt<>(0, line));
    }
}

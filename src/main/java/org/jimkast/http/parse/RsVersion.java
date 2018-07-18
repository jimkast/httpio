package org.jimkast.http.parse;

import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class RsVersion extends TextEnvelope {
    public RsVersion(HttpHead head) {
        this(new HttpHead.LineParts(head));
    }

    public RsVersion(Iterable<String> line) {
        super(new ItemAt<>(0, line));
    }
}

package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.text.stream.SplitText;

public final class HeaderInnerValues extends IterableEnvelope<String> {
    public HeaderInnerValues(String name, HttpHead head) {
        this(new HttpHeaderValue(head, name));
    }

    public HeaderInnerValues(CharSequence header) {
        super(new SplitText("\\s*;\\s*", header));
    }
}

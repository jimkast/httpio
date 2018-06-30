package org.jimkast.http.rq;

import org.jimkast.text.LazyText;
import org.jimkast.http.HttpHead;

public final class RqUri extends LazyText {
    public RqUri(HttpHead head) {
        this(new LazyText(head::line));
    }

    public RqUri(CharSequence str) {
        super(() -> str.toString().split("\\s+", 3)[1]);
    }
}

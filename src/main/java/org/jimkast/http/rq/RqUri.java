package org.jimkast.http.rq;

import org.jimkast.text.LazyText;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpMessage;

public final class RqUri extends LazyText {
    public RqUri(HttpMessage message) {
        this(new LazyText(() -> message.head().line()));
    }

    public RqUri(HttpHead head) {
        this(new LazyText(head::line));
    }

    public RqUri(CharSequence str) {
        super(() -> str.toString().split("\\s+", 3)[1]);
    }
}

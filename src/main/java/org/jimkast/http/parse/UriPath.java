package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.text.SubstringBefore;
import org.jimkast.text.TextEnvelope;

public final class UriPath extends TextEnvelope {
    public UriPath(HttpHead head) {
        this(new RqURI(head));
    }

    public UriPath(CharSequence str) {
        super(new SubstringBefore(str, "?", str));
    }
}

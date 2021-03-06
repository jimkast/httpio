package org.jimkast.http.parse.uri;

import org.jimkast.http.HttpHead;
import org.jimkast.http.parse.line.RqURI;
import org.jimkast.text.TextBefore;
import org.jimkast.text.TextEnvelope;

public final class UriPath extends TextEnvelope {
    public UriPath(HttpHead head) {
        this(new RqURI(head));
    }

    public UriPath(CharSequence str) {
        super(new TextBefore(str, "?", str));
    }
}

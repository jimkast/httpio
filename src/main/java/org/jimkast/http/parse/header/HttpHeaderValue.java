package org.jimkast.http.parse.header;

import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class HttpHeaderValue extends TextEnvelope {
    public HttpHeaderValue(HttpHead req, CharSequence name) {
        this(req, name, "");
    }

    public HttpHeaderValue(HttpHead head, CharSequence name, CharSequence def) {
        super(new ItemAt<>(new HttpHeaderValues(head, name), 0, input -> def.toString()));
    }
}

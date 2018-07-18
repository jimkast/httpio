package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.map.Prop;
import org.jimkast.map.PropsValue;
import org.jimkast.text.TextEnvelope;

public final class HttpHeaderValue extends TextEnvelope {
    public HttpHeaderValue(HttpHead req, String name) {
        this(req, name, "");
    }

    public HttpHeaderValue(HttpHead head, String name, CharSequence def) {
        this(new HttpHead.Headers(head), name, def);
    }

    public HttpHeaderValue(Iterable<Prop> head, String name, CharSequence def) {
        super(new PropsValue(def, name, head));
    }
}

package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.Prop;
import org.jimkast.map.PropsSplit;

public final class RqCookies extends IterableEnvelope<Prop> {
    public RqCookies(HttpHead head) {
        this(new HttpHeaderValue(head, "Cookie"));
    }

    public RqCookies(CharSequence header) {
        super(new PropsSplit("\\s*;\\s*", "\\s*=\\s*", header));
    }
}

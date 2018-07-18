package org.jimkast.http.parse.header;

import org.jimkast.http.HttpHead;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.Prop;

public final class RqCookies extends IterableEnvelope<Prop> {
    public RqCookies(HttpHead head) {
        this(new HttpHeaderValue(head, "Cookie"));
    }

    public RqCookies(CharSequence header) {
        super(new HeaderMetaProps(header));
    }
}

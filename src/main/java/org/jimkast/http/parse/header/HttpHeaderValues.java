package org.jimkast.http.parse.header;

import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.http.HttpHead;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.PropsValues;

public final class HttpHeaderValues extends IterableEnvelope<String> {
    public HttpHeaderValues(HttpHead head, CharSequence name) {
        super(
            new PropsValues(
                new ChkEqualsIgnoreCase(name),
                new HttpHead.Headers(head)
            )
        );
    }
}

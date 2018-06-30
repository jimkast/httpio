package org.jimkast.http.head;

import org.jimkast.http.HttpHead;
import org.jimkast.text.Concat;

public final class HeadWithContentType extends HttpHead.Envelope {
    public HeadWithContentType(CharSequence type, HttpHead origin) {
        super(new HeadWithHeaders(origin, new Concat("Content-Type: ", type)));
    }

    public HeadWithContentType(CharSequence type, CharSequence encoding, HttpHead origin) {
        super(new HeadWithHeaders(origin, new Concat("Content-Type: ", type, "; charset=", encoding)));
    }
}

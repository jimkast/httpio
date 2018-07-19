package org.jimkast.http.head;

import org.jimkast.http.HttpHead;
import org.jimkast.map.prop.PropSimple;
import org.jimkast.text.Concat;

public final class HeadWithContentType extends HttpHead.Envelope {
    public HeadWithContentType(CharSequence type, CharSequence encoding, HttpHead origin) {
        this(new Concat(type, "; charset=", encoding), origin);
    }

    public HeadWithContentType(CharSequence value, HttpHead origin) {
        super(new HeadWithHeaders(origin, new PropSimple("Content-Type", value)));
    }
}

package org.jimkast.http.parse.header;

import org.jimkast.http.HttpHead;
import org.jimkast.map.props.PropsValue;
import org.jimkast.text.TextEnvelope;

public final class HttpCharset extends TextEnvelope {
    public HttpCharset(HttpHead head) {
        this(head, "");
    }

    public HttpCharset(HttpHead head, CharSequence def) {
        this(new HttpHeaderValue(head, "Content-Type"), def);
    }

    public HttpCharset(CharSequence ctype, CharSequence def) {
        super(new PropsValue(def, "charset", new HeaderMetaProps(ctype)));
    }
}

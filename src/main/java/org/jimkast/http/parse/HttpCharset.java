package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.map.PropsValue;
import org.jimkast.text.TextEnvelope;

public final class HttpCharset extends TextEnvelope {
    public HttpCharset(HttpHead head) {
        this(head, "");
    }

    public HttpCharset(HttpHead head, CharSequence def) {
        this(new HttpHeaderValue(head, "Content-Type"), def);
    }

    public HttpCharset(CharSequence ctype, CharSequence def) {
        super(new PropsValue(def, "charset", new HeaderInnerValues(ctype)));
    }

    private HttpCharset(CharSequence value) {
        super(() -> {
            String enc = value.toString();
            if (enc.length() > 2 && enc.startsWith("\"") && enc.endsWith("\"")) {
                enc = enc.substring(1, enc.length() - 1).trim();
            }
            return enc;
        });
    }
}

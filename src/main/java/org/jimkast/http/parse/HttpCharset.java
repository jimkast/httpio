package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class HttpCharset extends TextEnvelope {
    public HttpCharset(HttpHead head) {
        this(head, "");
    }

    public HttpCharset(HttpHead head, CharSequence def) {
        this(new HttpHeaderValue(head, "Content-Type"), def);
    }

    public HttpCharset(CharSequence ctype, CharSequence def) {
        super(() -> {
            String type = ctype.toString();
            if (type.isEmpty()) {
                return def.toString();
            }
            int start = type.indexOf("charset=");
            if (start < 0) {
                return "";
            }
            String encoding = type.substring(start + 8);
            int end = encoding.indexOf(';');
            if (end >= 0) {
                encoding = encoding.substring(0, end);
            }
            encoding = encoding.trim();
            if (encoding.length() > 2 && encoding.startsWith("\"") && encoding.endsWith("\"")) {
                encoding = encoding.substring(1, encoding.length() - 1);
            }
            return encoding.trim();
        });
    }
}

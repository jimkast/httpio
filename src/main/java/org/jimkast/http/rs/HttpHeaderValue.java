package org.jimkast.http.rs;


import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;
import org.jimkast.text.LazyText;

public final class HttpHeaderValue extends LazyText {
    public HttpHeaderValue(HttpHead msg, CharSequence name) {
        this(msg, name, "");
    }

    public HttpHeaderValue(HttpHead msg, CharSequence name, CharSequence def) {
        super(() -> {
            String key = name.toString();
            for (Header h : msg.headers()) {
                if (h.name().equalsIgnoreCase(key)) {
                    return h.value();
                }
            }
            return def.toString();
        });
    }

}

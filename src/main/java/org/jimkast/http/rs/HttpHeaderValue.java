package org.jimkast.http.rs;


import org.jimkast.http.HttpHead;
import org.jimkast.map.Prop;
import org.jimkast.text.TextEnvelope;

public final class HttpHeaderValue extends TextEnvelope {
    public HttpHeaderValue(HttpHead msg, CharSequence name) {
        this(msg, name, "");
    }

    public HttpHeaderValue(HttpHead msg, CharSequence name, CharSequence def) {
        super(() -> {
            String key = name.toString();
            for (Prop h : msg.headers()) {
                if (h.name().equalsIgnoreCase(key)) {
                    return h.value();
                }
            }
            return def.toString();
        });
    }

}

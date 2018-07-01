package org.jimkast.http.rs;


import org.jimkast.http.HttpHead;
import org.jimkast.text.LazyText;

public final class HttpHeaderValue extends LazyText {
    public HttpHeaderValue(HttpHead msg, CharSequence name) {
        this(msg, name, "");
    }

    public HttpHeaderValue(HttpHead msg, CharSequence name, CharSequence def) {
        super(() -> {
            String key = name.toString();
            for (String h : msg.headers()) {
                String[] parts = h.split(":", 2);
                if (parts[0].trim().equalsIgnoreCase(key)) {
                    return parts[1].trim();
                }
            }
            return def.toString();
        });
    }

}

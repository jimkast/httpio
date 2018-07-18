package org.jimkast.http.parse;

import org.jimkast.http.HttpHead;
import org.jimkast.map.Prop;
import org.jimkast.text.TextEnvelope;

public final class RqHeaderValue extends TextEnvelope {
    public RqHeaderValue(HttpHead req, CharSequence name) {
        this(req, name, "");
    }

    public RqHeaderValue(HttpHead head, CharSequence name, CharSequence def) {
        this(new HttpHead.Headers(head), name, def);
    }

    public RqHeaderValue(Iterable<Prop> head, CharSequence name, CharSequence def) {
        super(() -> {
            String n = name.toString();
            for (Prop header : head) {
                if (header.name().equalsIgnoreCase(n)) {
                    return header.value();
                }
            }
            return def.toString();
        });
    }
}

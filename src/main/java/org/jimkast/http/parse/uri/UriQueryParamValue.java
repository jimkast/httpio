package org.jimkast.http.parse.uri;

import org.jimkast.http.HttpHead;
import org.jimkast.map.Prop;
import org.jimkast.text.TextEnvelope;

public final class UriQueryParamValue extends TextEnvelope {
    public UriQueryParamValue(HttpHead head, CharSequence key) {
        this(head, key, "");
    }

    public UriQueryParamValue(HttpHead head, CharSequence key, CharSequence def) {
        this(new UriQueryParams(head), key, def);
    }

    public UriQueryParamValue(Iterable<Prop> pairs, CharSequence key) {
        this(pairs, key, "");
    }

    public UriQueryParamValue(Iterable<Prop> pairs, CharSequence key, CharSequence def) {
        super(() -> {
            String name = key.toString();
            for (Prop pair : pairs) {
                if (name.equalsIgnoreCase(pair.name())) {
                    return pair.value();
                }
            }
            return def.toString();
        });
    }
}

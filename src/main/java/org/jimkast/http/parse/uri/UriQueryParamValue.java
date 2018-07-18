package org.jimkast.http.parse.uri;

import java.util.Map;
import org.jimkast.http.HttpHead;
import org.jimkast.text.TextEnvelope;

public final class UriQueryParamValue extends TextEnvelope {
    public UriQueryParamValue(HttpHead head, CharSequence key) {
        this(head, key, "");
    }

    public UriQueryParamValue(HttpHead head, CharSequence key, CharSequence def) {
        this(new UriQueryParams(head), key, def);
    }

    public UriQueryParamValue(Iterable<Map.Entry<String, String>> pairs, CharSequence key) {
        this(pairs, key, "");
    }

    public UriQueryParamValue(Iterable<Map.Entry<String, String>> pairs, CharSequence key, CharSequence def) {
        super(() -> {
            String name = key.toString();
            for (Map.Entry<String, String> pair : pairs) {
                if (name.equalsIgnoreCase(pair.getKey())) {
                    return pair.getValue();
                }
            }
            return def.toString();
        });
    }
}

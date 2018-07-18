package org.jimkast.http.parse.header;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.cactoos.map.MapEnvelope;
import org.cactoos.scalar.StickyScalar;
import org.jimkast.http.HttpHead;
import org.jimkast.map.Prop;

public final class HttpHeadersAnalyzed extends MapEnvelope<String, List<String>> {

    public HttpHeadersAnalyzed(HttpHead head) {
        this(head, new TreeMap<>(String.CASE_INSENSITIVE_ORDER));
    }

    public HttpHeadersAnalyzed(HttpHead head, Map<String, List<String>> map) {
        super(new StickyScalar<>(() -> {
            for (Prop prop : head.headers()) {
                String name = prop.name();
                for (String value : new HeaderListValues(prop.value())) {
                    map.computeIfAbsent(name, s -> new ArrayList<>()).add(value);
                }
            }
            return map;
        }
        ));
    }
}

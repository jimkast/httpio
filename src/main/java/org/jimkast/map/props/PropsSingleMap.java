package org.jimkast.map.props;

import java.util.Map;
import java.util.TreeMap;
import org.cactoos.map.MapEnvelope;
import org.jimkast.map.Prop;

public final class PropsSingleMap extends MapEnvelope<String, String> {
    public PropsSingleMap(Iterable<Prop> props) {
        this(new TreeMap<>(String.CASE_INSENSITIVE_ORDER), props);
    }

    public PropsSingleMap(Map<String, String> map, Iterable<Prop> props) {
        super(
            () -> {
                for (Prop prop : props) {
                    map.putIfAbsent(prop.name(), prop.value());
                }
                return map;
            }
        );
    }
}

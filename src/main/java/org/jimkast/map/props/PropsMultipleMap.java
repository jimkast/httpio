package org.jimkast.map.props;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.cactoos.map.MapEnvelope;
import org.jimkast.map.Prop;

public final class PropsMultipleMap extends MapEnvelope<String, List<String>> {
    public PropsMultipleMap(Iterable<Prop> props) {
        this(new TreeMap<>(String.CASE_INSENSITIVE_ORDER), props);
    }

    public PropsMultipleMap(Map<String, List<String>> map, Iterable<Prop> props) {
        super(
            () -> {
                for (Prop prop : props) {
                    map.computeIfAbsent(prop.name(), s -> new ArrayList<>()).add(prop.value());
                }
                return map;
            }
        );
    }
}

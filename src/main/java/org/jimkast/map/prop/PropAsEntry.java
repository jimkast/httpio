package org.jimkast.map.prop;

import java.util.Map;
import org.jimkast.map.Prop;

public final class PropAsEntry implements Map.Entry<String, String> {
    private final Prop prop;

    public PropAsEntry(Prop prop) {
        this.prop = prop;
    }

    @Override
    public String getKey() {
        return prop.name();
    }

    @Override
    public String getValue() {
        return prop.value();
    }

    @Override
    public String setValue(String value) {
        throw new UnsupportedOperationException("$setValue");
    }
}

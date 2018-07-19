package org.jimkast.map.prop;

import java.util.Map;
import org.jimkast.map.Prop;

public final class PropOfEntry implements Prop {
    private final Map.Entry<? extends CharSequence, ? extends CharSequence> entry;

    public PropOfEntry(Map.Entry<? extends CharSequence, ? extends CharSequence> entry) {
        this.entry = entry;
    }

    @Override
    public String name() {
        return entry.getKey().toString();
    }

    @Override
    public String value() {
        return entry.getValue().toString();
    }
}

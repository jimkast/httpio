package org.jimkast.map.prop;

import org.jimkast.map.Prop;

public final class PropSimple implements Prop {
    private final CharSequence name;
    private final CharSequence value;

    public PropSimple(CharSequence name, CharSequence value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String name() {
        return name.toString();
    }

    @Override
    public String value() {
        return value.toString();
    }
}

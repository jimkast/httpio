package org.jimkast.map.prop;

import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.map.Prop;

public final class PropSticky implements Prop {
    private final UncheckedScalar<String> name;
    private final UncheckedScalar<String> value;

    public PropSticky(Prop origin) {
        this(
            new UncheckedScalar<>(new StickyScalar<>(origin::name)),
            new UncheckedScalar<>(new StickyScalar<>(origin::value))
        );
    }

    private PropSticky(UncheckedScalar<String> name, UncheckedScalar<String> value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String name() {
        return name.value();
    }

    @Override
    public String value() {
        return value.value();
    }
}

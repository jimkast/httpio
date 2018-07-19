package org.jimkast.map.prop;

import java.util.Iterator;
import org.cactoos.iterable.Joined;
import org.cactoos.iterable.Repeated;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.map.Prop;

public final class PropParts implements Prop {
    private final UncheckedScalar<PropSimple> scalar;

    public PropParts(Iterable<String> parts) {
        this(new UncheckedScalar<>(() -> {
            Iterator<String> iter = new Joined<String>(parts, new Repeated<>(2, "")).iterator();
            return new PropSimple(iter.next(), iter.next());
        }));
    }

    private PropParts(UncheckedScalar<PropSimple> scalar) {
        this.scalar = scalar;
    }

    @Override
    public String name() {
        return scalar.value().name();
    }

    @Override
    public String value() {
        return scalar.value().value();
    }
}

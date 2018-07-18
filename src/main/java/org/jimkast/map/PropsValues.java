package org.jimkast.map;

import java.util.function.Predicate;
import org.cactoos.iterable.Filtered;
import org.cactoos.iterable.Mapped;
import org.jimkast.iterable.IterableEnvelope;

public final class PropsValues extends IterableEnvelope<String> {
    public PropsValues(String name, Iterable<Prop> props) {
        this(name::equalsIgnoreCase, props);
    }

    public PropsValues(Predicate<String> check, Iterable<Prop> props) {
        super(
            new Mapped<>(
                Prop::value,
                new Filtered<>(
                    hdr -> check.test(hdr.name()),
                    props
                )
            )
        );
    }
}

package org.jimkast.iterable;

import java.util.Arrays;
import org.cactoos.iterable.Mapped;

public final class StringValues extends IterableEnvelope<String> {
    public StringValues(Object ... o) {
        this(Arrays.asList(o));
    }

    public StringValues(Iterable<?> origin) {
        super(new Mapped<>(Object::toString, origin));
    }
}

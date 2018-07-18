package org.jimkast.http.head;

import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.http.Prop;

public final class HeaderParsed implements Prop {
    private final UncheckedScalar<String[]> parts;

    public HeaderParsed(CharSequence full) {
        this(new UncheckedScalar<>(new StickyScalar<>(() -> full.toString().split("\\s*:\\s*", 2))));
    }

    public HeaderParsed(UncheckedScalar<String[]> parts) {
        this.parts = parts;
    }

    @Override
    public String name() {
        return parts.value()[0];
    }

    @Override
    public String value() {
        return parts.value()[1];
    }
}

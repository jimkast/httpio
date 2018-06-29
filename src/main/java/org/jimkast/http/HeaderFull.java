package org.jimkast.http;

import org.cactoos.scalar.UncheckedScalar;

public final class HeaderFull implements Header {
    private final CharSequence text;
    private final UncheckedScalar<String[]> parts;

    public HeaderFull(CharSequence text) {
        this.text = text;
        this.parts = new UncheckedScalar<>(() -> text.toString().split(":"));
    }

    @Override
    public String name() {
        return parts.value()[0].trim();
    }

    @Override
    public String value() {
        return parts.value()[2].trim();
    }

    public String toString() {
        return text.toString();
    }
}

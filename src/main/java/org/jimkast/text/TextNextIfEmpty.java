package org.jimkast.text;

import java.util.Arrays;
import org.cactoos.scalar.FirstOf;
import org.jimkast.iterable.StringValues;

public final class TextNextIfEmpty extends TextEnvelope {
    public TextNextIfEmpty(CharSequence... all) {
        this(Arrays.asList(all));
    }

    public TextNextIfEmpty(Iterable<? extends CharSequence> all) {
        super(new FirstOf<>(input -> !input.isEmpty(), new StringValues(all), () -> ""));
    }
}

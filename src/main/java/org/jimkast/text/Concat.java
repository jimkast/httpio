package org.jimkast.text;

import java.util.Arrays;
import org.cactoos.list.Mapped;

public final class Concat extends LazyText {
    public Concat(CharSequence... parts) {
        this(Arrays.asList(parts));
    }

    public Concat(Iterable<CharSequence> parts) {
        super(() -> String.join("", new Mapped<>(CharSequence::toString, parts)));
    }
}

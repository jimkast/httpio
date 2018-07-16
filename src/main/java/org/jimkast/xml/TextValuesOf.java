package org.jimkast.xml;

import java.util.Iterator;
import org.cactoos.iterable.Mapped;

public final class TextValuesOf implements Iterable<String> {
    private final Iterable origin;

    public TextValuesOf(Xdm xdm) {
        this.origin = new Mapped<>(Xdm::text, xdm);
    }

    @Override
    public Iterator iterator() {
        return origin.iterator();
    }
}

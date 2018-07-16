package org.jimkast.iterable;

import java.util.HashSet;
import java.util.Set;
import org.cactoos.collection.CollectionEnvelope;

public final class Distinct<T> extends CollectionEnvelope<T> {
    public Distinct(Iterable<T> origin) {
        super(() -> {
            Set<T> set = new HashSet<>();
            for (T t : origin) {
                set.add(t);
            }
            return set;
        });
    }
}

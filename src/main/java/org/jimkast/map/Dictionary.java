package org.jimkast.map;

import org.jimkast.iterable.IterableWithLength;

public interface Dictionary<K, V> extends Mapping<K, V> {
    IterableWithLength<K> keys();

    V map(K key);
}

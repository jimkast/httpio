package org.jimkast.map;

public interface Dictionary<K, V> extends Mapping<K, V> {
    Iterable<K> keys();

    V map(K key);

    int size();
}

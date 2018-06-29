package org.jimkast.util;

import java.util.HashMap;
import java.util.Map;

public interface Mapping<K, V> {
    V map(K key);


    final class Simple<K, V> implements Mapping<K, V> {
        private final Map<K, V> map;
        private final V def;

        public Simple(V def) {
            this(def, new HashMap<>());
        }

        public Simple(V def, Map<K, V> map) {
            this.map = map;
            this.def = def;
        }

        @Override
        public V map(K key) {
            return map.getOrDefault(key, def);
        }

        public Simple<K, V> with(K key, V value) {
            map.put(key, value);
            return this;
        }
    }


    class Envelope<K, V> implements Mapping<K, V> {
        private final Mapping<K, V> mapping;

        public Envelope(Mapping<K, V> mapping) {
            this.mapping = mapping;
        }

        @Override
        public final V map(K key) {
            return mapping.map(key);
        }
    }
}

package org.jimkast.map;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class FluentMap<K, V> implements Map<K, V> {
    private final Map<K, V> map;

    public FluentMap() {
        this(new LinkedHashMap<>());
    }

    public FluentMap(K key, V value) {
        this.map = new LinkedHashMap<>();
        this.map.put(key, value);
    }

    public FluentMap(Map<K, V> map) {
        this.map = map;
    }

    public FluentMap<K, V> with(K key, V value) {
        put(key, value);
        return this;
    }

    public FluentMap<K, V> withAll(Map<K, V> values) {
        putAll(values);
        return this;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}
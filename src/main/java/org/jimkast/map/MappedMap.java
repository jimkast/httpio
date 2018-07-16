package org.jimkast.map;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.cactoos.iterable.Mapped;
import org.jimkast.iterable.IterableAsSet;

public final class MappedMap<K, V, O> implements Map<K, V> {
    private final Map<K, O> doc;
    private final Function<O, V> mapper;

    public MappedMap(Map<K, O> doc, Function<O, V> mapper) {
        this.doc = doc;
        this.mapper = mapper;
    }

    @Override
    public V get(Object key) {
        return mapper.apply(doc.get(key));
    }

    @Override
    public int size() {
        return doc.size();
    }

    @Override
    public boolean isEmpty() {
        return doc.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return doc.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Set<K> keySet() {
        return doc.keySet();
    }

    @Override
    public Collection<V> values() {
        return new IterableAsSet<>(new Mapped<>(mapper::apply, doc.values()));
//        return doc.values().stream().map(mapper).collect(Collectors.toList());
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new IterableAsSet<>(new Mapped<>(input -> new AbstractMap.SimpleEntry<>(input.getKey(), mapper.apply(input.getValue())), doc.entrySet()));
//        return doc.entrySet().stream().map(input -> new AbstractMap.SimpleEntry<>(input.getKey(), mapper.apply(input.getValue()))).collect(Collectors.toSet());
    }


    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException("#put");
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("#remove");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("#putAll");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("#clear");
    }

}


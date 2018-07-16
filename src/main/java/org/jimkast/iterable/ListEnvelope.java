package org.jimkast.iterable;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.cactoos.Scalar;
import org.cactoos.collection.CollectionEnvelope;
import org.cactoos.scalar.UncheckedScalar;

@SuppressWarnings("PMD.TooManyMethods")
public class ListEnvelope<T> extends CollectionEnvelope<T> implements List<T> {
    private final UncheckedScalar<List<T>> list;

    public ListEnvelope(List<T> list) {
        this(() -> list);
    }

    public ListEnvelope(final Scalar<List<T>> src) {
        super(src::value);
        this.list = new UncheckedScalar<>(src);
    }

    @Override
    public final boolean addAll(final int index,
                                final Collection<? extends T> items) {
        throw new UnsupportedOperationException("#addAll()");
    }

    @Override
    public final T get(final int index) {
        return this.list.value().get(index);
    }

    @Override
    public final T set(final int index, final T element) {
        throw new UnsupportedOperationException("#set()");
    }

    @Override
    public final void add(final int index, final T element) {
        throw new UnsupportedOperationException("#add()");
    }

    @Override
    public final T remove(final int index) {
        throw new UnsupportedOperationException("#remove()");
    }

    @Override
    public final int indexOf(final Object item) {
        return this.list.value().indexOf(item);
    }

    @Override
    public final int lastIndexOf(final Object item) {
        return this.list.value().lastIndexOf(item);
    }

    @Override
    public final ListIterator<T> listIterator() {
        return this.list.value().listIterator();
    }

    @Override
    public final ListIterator<T> listIterator(final int index) {
        return this.list.value().listIterator(index);
    }

    @Override
    public final List<T> subList(final int start, final int end) {
        return this.list.value().subList(start, end);
    }
}


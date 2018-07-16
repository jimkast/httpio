package org.jimkast.iterable;

import java.util.Iterator;
import org.cactoos.iterable.RangeOf;

public final class IntRangeOf implements Iterable<Integer> {
    private final Iterable<Integer> numbers;

    public IntRangeOf(int to) {
        this(1, to);
    }

    public IntRangeOf(int from, int to) {
        this(from, to, 1);
    }

    public IntRangeOf(int from, int to, int gap) {
        this.numbers = new RangeOf<>(from, to, i -> i + gap);
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}

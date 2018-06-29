package org.jimkast.text;


import org.cactoos.Scalar;
import org.cactoos.Text;
import org.cactoos.scalar.UncheckedScalar;

public class LazyText implements CharSequence, Text {
    private final UncheckedScalar<String> str;

    public LazyText(CharSequence str) {
        this(str::toString);
    }

    public LazyText(LazyText text) {
        this(text::toString);
    }

    public LazyText(Scalar<String> str) {
        this(new UncheckedScalar<>(str));
    }

    public LazyText(UncheckedScalar<String> str) {
        this.str = str;
    }

    @Override
    public final int length() {
        return str.value().length();
    }

    @Override
    public final char charAt(int index) {
        return str.value().charAt(index);
    }

    @Override
    public final CharSequence subSequence(int start, int end) {
        return str.value().subSequence(start, end);
    }

    @Override
    public final String asString() {
        return str.value();
    }

    @Override
    public final String toString() {
        return str.value();
    }
}

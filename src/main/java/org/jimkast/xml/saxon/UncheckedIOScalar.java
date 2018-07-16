package org.jimkast.xml.saxon;

import java.io.IOException;
import java.io.UncheckedIOException;
import org.cactoos.Scalar;
import org.cactoos.scalar.IoCheckedScalar;

public final class UncheckedIOScalar<T> implements Scalar<T> {
    private final IoCheckedScalar<T> origin;

    public UncheckedIOScalar(IoCheckedScalar<T> origin) {
        this.origin = origin;
    }

    @Override
    public T value() {
        try {
            return origin.value();
        } catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }
}

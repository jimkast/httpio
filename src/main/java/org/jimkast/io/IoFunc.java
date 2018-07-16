package org.jimkast.io;

import java.io.IOException;
import org.cactoos.Func;

public interface IoFunc<X, Y> extends Func<X, Y> {
    @Override
    Y apply(X input) throws IOException;
}

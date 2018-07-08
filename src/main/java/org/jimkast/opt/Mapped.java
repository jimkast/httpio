package org.jimkast.opt;

import org.cactoos.Func;

public final class Mapped<X, Y> implements Possible<Y> {
    private final Func<X, Y> mapper;
    private final Possible<X> origin;

    public Mapped(Func<X, Y> mapper, Possible<X> origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public boolean exists() {
        return origin.exists();
    }

    @Override
    public Y value() throws Exception {
        return mapper.apply(origin.value());
    }
}

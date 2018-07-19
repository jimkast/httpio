package org.jimkast.map.prop;

import java.util.function.Function;
import org.jimkast.map.Prop;

public final class PropMapped implements Prop {
    private final Function<String, String> mapper;
    private final Prop origin;

    public PropMapped(Function<String, String> mapper, Prop origin) {
        this.mapper = mapper;
        this.origin = origin;
    }

    @Override
    public String name() {
        return origin.name();
    }

    @Override
    public String value() {
        return mapper.apply(origin.value());
    }
}

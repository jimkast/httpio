package org.jimkast.map.prop;

import java.util.function.Function;
import org.jimkast.map.Prop;

public final class PropMappedBoth extends Prop.Envelope {
    public PropMappedBoth(Function<String, String> mapper, Prop origin) {
        super(
            new PropMappedName(
                mapper,
                new PropMapped(
                    mapper, origin
                )
            )
        );
    }
}

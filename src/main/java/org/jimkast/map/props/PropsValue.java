package org.jimkast.map.props;

import java.util.function.Predicate;
import org.jimkast.map.Prop;
import org.jimkast.text.TextEnvelope;

public final class PropsValue extends TextEnvelope {
    public PropsValue(Predicate<String> check, Iterable<Prop> props) {
        this("", check, props);
    }

    public PropsValue(CharSequence name, Iterable<Prop> props) {
        this("", name, props);
    }


    public PropsValue(CharSequence def, CharSequence name, Iterable<Prop> props) {
        this(def, s -> name.toString().equalsIgnoreCase(s), props);
    }

    public PropsValue(CharSequence def, Predicate<String> check, Iterable<Prop> props) {
        super(() -> {
            for (Prop prop : props) {
                if (check.test(prop.name())) {
                    return prop.value();
                }
            }
            return def.toString();
        });
    }
}

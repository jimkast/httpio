package org.jimkast.map;

import java.util.function.Predicate;
import org.jimkast.text.TextEnvelope;

public final class PropsValue extends TextEnvelope {
    public PropsValue(Predicate<String> check, Iterable<Prop> props) {
        this("", check, props);
    }

    public PropsValue(String name, Iterable<Prop> props) {
        this("", name, props);
    }


    public PropsValue(CharSequence def, String name, Iterable<Prop> props) {
        this(def, name::equalsIgnoreCase, props);
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

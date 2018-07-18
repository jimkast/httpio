package org.jimkast.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.cactoos.iterable.StickyIterable;
import org.cactoos.scalar.UncheckedScalar;

public interface Prop {
    String name();

    String value();


    class Envelope implements Prop {
        private final Prop prop;

        public Envelope(Prop prop) {
            this.prop = prop;
        }

        @Override
        public final String name() {
            return prop.name();
        }

        @Override
        public final String value() {
            return prop.value();
        }
    }


    final class Simple implements Prop {
        private final CharSequence name;
        private final CharSequence value;

        public Simple(CharSequence name, CharSequence value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String name() {
            return name.toString();
        }

        @Override
        public String value() {
            return value.toString();
        }
    }


    final class Parts implements Prop {
        private final UncheckedScalar<Simple> scalar;

        public Parts(Iterable<String> parts) {
            this.scalar = new UncheckedScalar<>(() -> {
                Iterator<String> iter = parts.iterator();
                return new Simple(
                    iter.next(),
                    iter.next()
                );
            });
        }

        @Override
        public String name() {
            return scalar.value().name();
        }

        @Override
        public String value() {
            return scalar.value().value();
        }
    }


    final class Split extends Envelope {
        public Split(String split, CharSequence text) {
            this(Pattern.compile(split), text);
        }

        public Split(Pattern split, CharSequence text) {
            super(new Parts(new StickyIterable<>(() -> Arrays.asList(split.split(text.toString(), 2)).iterator())));
        }
    }


    final class AsEntry implements Map.Entry<String, String> {
        private final Prop prop;

        public AsEntry(Prop prop) {
            this.prop = prop;
        }

        @Override
        public String getKey() {
            return prop.name();
        }

        @Override
        public String getValue() {
            return prop.value();
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException("$setValue");
        }
    }


    final class OfEntry implements Prop {
        private final Map.Entry<? extends CharSequence, ? extends CharSequence> entry;

        public OfEntry(Map.Entry<? extends CharSequence, ? extends CharSequence> entry) {
            this.entry = entry;
        }

        @Override
        public String name() {
            return entry.getKey().toString();
        }

        @Override
        public String value() {
            return entry.getValue().toString();
        }
    }
}

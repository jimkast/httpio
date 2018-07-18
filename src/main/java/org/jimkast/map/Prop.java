package org.jimkast.map;

import java.util.Map;

public interface Prop {
    String name();

    String value();


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

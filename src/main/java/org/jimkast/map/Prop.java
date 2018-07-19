package org.jimkast.map;

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
}

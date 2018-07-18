package org.jimkast.http;

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
}

package org.jimkast.http;

import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;

public interface Header {
    String name();

    String value();


    final class Parsed implements Header {
        private final UncheckedScalar<String[]> parts;

        public Parsed(CharSequence full) {
            this(new UncheckedScalar<>(new StickyScalar<>(() -> full.toString().split("\\s*:\\s*", 2))));
        }

        public Parsed(UncheckedScalar<String[]> parts) {
            this.parts = parts;
        }

        @Override
        public String name() {
            return parts.value()[0];
        }

        @Override
        public String value() {
            return parts.value()[1];
        }
    }

    final class Simple implements Header {
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

package org.jimkast.http;

import org.jimkast.http.parse.header.HeaderMetaProps;
import org.jimkast.map.Prop;
import org.jimkast.text.TextAfter;
import org.jimkast.text.TextBefore;

public interface HeaderPart {
    Iterable<Prop> props();

    String value();


    final class Parsed implements HeaderPart {
        private final Iterable<Prop> props;
        private final CharSequence value;

        public Parsed(CharSequence text) {
            this(
                new HeaderMetaProps(new TextAfter(text, ";", text)),
                new TextBefore(text, ";")
            );
        }

        Parsed(Iterable<Prop> props, CharSequence value) {
            this.props = props;
            this.value = value;
        }

        @Override
        public Iterable<Prop> props() {
            return props;
        }

        @Override
        public String value() {
            return value.toString();
        }
    }
}

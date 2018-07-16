package org.jimkast.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;
import java.util.Iterator;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public interface Xdm extends Iterable<Xdm> {
    Xdm query(CharSequence xpath) throws IOException;

    String text();

    String serialize();

    Source source();

    @Override
    Iterator<Xdm> iterator();


    Xdm EMPTY = new Xdm() {
        @Override
        public Xdm query(CharSequence xpath) {
            return EMPTY;
        }

        @Override
        public String text() {
            return "";
        }

        @Override
        public String serialize() {
            return "";
        }

        @Override
        public Source source() {
            return new StreamSource(new StringReader("<dummy/>"));
        }

        @Override
        public Iterator<Xdm> iterator() {
            return Collections.<Xdm>emptyList().iterator();
        }
    };


    class Envelope implements Xdm {
        private final Xdm origin;

        public Envelope(Xdm origin) {
            this.origin = origin;
        }

        @Override
        public final Xdm query(CharSequence xpath) throws IOException {
            return origin.query(xpath);
        }

        @Override
        public final String text() {
            return origin.text();
        }

        @Override
        public final String serialize() {
            return origin.serialize();
        }

        @Override
        public final Source source() {
            return origin.source();
        }

        @Override
        public final Iterator<Xdm> iterator() {
            return origin.iterator();
        }
    }
}

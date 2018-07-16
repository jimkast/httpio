package org.jimkast.xml;

import java.io.IOException;
import javax.xml.transform.Source;

public interface XQuery {
    Xdm evaluate(Source source) throws IOException;

    XQuery with(CharSequence key, Xdm val);


    class Envelope implements XQuery {
        private final XQuery origin;

        public Envelope(XQuery origin) {
            this.origin = origin;
        }

        @Override
        public final Xdm evaluate(Source source) throws IOException {
            return origin.evaluate(source);
        }

        @Override
        public final XQuery with(CharSequence key, Xdm val) {
            return origin.with(key, val);
        }
    }
}

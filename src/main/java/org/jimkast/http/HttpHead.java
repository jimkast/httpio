package org.jimkast.http;

import java.util.List;

public interface HttpHead {
    List<String> line();

    Iterable<Header> headers();


    class Envelope implements HttpHead {
        private final HttpHead origin;

        public Envelope(HttpHead origin) {
            this.origin = origin;
        }

        @Override
        public final List<String> line() {
            return origin.line();
        }

        @Override
        public final Iterable<Header> headers() {
            return origin.headers();
        }
    }
}

package org.jimkast.http;

public interface HttpHead {
    HttpLine line();

    Iterable<Header> headers();


    class Envelope implements HttpHead {
        private final HttpHead origin;

        public Envelope(HttpHead origin) {
            this.origin = origin;
        }

        @Override
        public final HttpLine line() {
            return origin.line();
        }

        @Override
        public final Iterable<Header> headers() {
            return origin.headers();
        }
    }
}

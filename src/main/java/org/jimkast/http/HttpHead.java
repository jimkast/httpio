package org.jimkast.http;

public interface HttpHead {
    Iterable<String> line();

    Iterable<Header> headers();


    class Envelope implements HttpHead {
        private final HttpHead origin;

        public Envelope(HttpHead origin) {
            this.origin = origin;
        }

        @Override
        public final Iterable<String> line() {
            return origin.line();
        }

        @Override
        public final Iterable<Header> headers() {
            return origin.headers();
        }
    }
}

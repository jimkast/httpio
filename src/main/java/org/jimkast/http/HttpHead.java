package org.jimkast.http;

public interface HttpHead {
    String line();

    Iterable<String> headers();


    class Envelope implements HttpHead {
        private final HttpHead origin;

        public Envelope(HttpHead origin) {
            this.origin = origin;
        }

        @Override
        public final String line() {
            return origin.line();
        }

        @Override
        public final Iterable<String> headers() {
            return origin.headers();
        }
    }
}

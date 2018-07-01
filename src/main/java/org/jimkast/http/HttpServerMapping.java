package org.jimkast.http;

public interface HttpServerMapping {
    HttpOut exchange(HttpIn in);


    class Envelope implements HttpServerMapping {
        private final HttpServerMapping origin;

        public Envelope(HttpServerMapping origin) {
            this.origin = origin;
        }

        @Override
        public final HttpOut exchange(HttpIn in) {
            return origin.exchange(in);
        }
    }
}

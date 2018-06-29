package org.jimkast.http;

import java.util.function.Predicate;

public interface HttpRoute extends Predicate<HttpHead> {
    @Override
    boolean test(HttpHead head);

    HttpServerMapping map();


    class Envelope implements HttpRoute {
        private final HttpRoute origin;

        public Envelope(HttpRoute origin) {
            this.origin = origin;
        }

        @Override
        public boolean test(HttpHead head) {
            return origin.test(head);
        }

        @Override
        public HttpServerMapping map() {
            return origin.map();
        }
    }
}

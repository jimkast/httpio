package org.jimkast.http;

import java.util.Iterator;
import org.jimkast.map.Prop;

public interface HttpHead {
    HttpLine line();

    Iterable<Prop> headers();


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
        public final Iterable<Prop> headers() {
            return origin.headers();
        }
    }


    final class LineParts implements Iterable<String> {
        private final HttpHead head;

        public LineParts(HttpHead head) {
            this.head = head;
        }

        @Override
        public Iterator<String> iterator() {
            return head.line().iterator();
        }
    }


    final class Headers implements Iterable<Prop> {
        private final HttpHead head;

        public Headers(HttpHead head) {
            this.head = head;
        }

        @Override
        public Iterator<Prop> iterator() {
            return head.headers().iterator();
        }
    }
}

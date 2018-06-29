package org.jimkast.http.head;

import org.cactoos.Scalar;
import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpMessage;

public final class MsgHead implements HttpHead {
    private final UncheckedScalar<HttpHead> head;

    public MsgHead(HttpMessage msg) {
        this(new StickyScalar<>(msg::head));
    }

    public MsgHead(Scalar<HttpHead> head) {
        this(new UncheckedScalar<>(head));
    }

    public MsgHead(UncheckedScalar<HttpHead> head) {
        this.head = head;
    }

    @Override
    public String line() {
        return head.value().line();
    }

    @Override
    public Iterable<String> headers() {
        return head.value().headers();
    }
}

package org.jimkast.http.head;

import java.util.Arrays;
import org.cactoos.iterable.Joined;
import org.cactoos.list.Mapped;
import org.jimkast.http.Prop;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpLine;
import org.jimkast.http.rs.RsEmpty;

public final class HeadWithHeaders implements HttpHead {
    private final HttpHead origin;
    private final Iterable<Prop> headers;

    public HeadWithHeaders(CharSequence... headers) {
        this(new RsEmpty(), headers);
    }

    public HeadWithHeaders(HttpHead origin, CharSequence... headers) {
        this(new Mapped<>(CharSequence::toString, Arrays.asList(headers)), origin);
    }

    public HeadWithHeaders(Iterable<String> headers) {
        this(headers, new RsEmpty());
    }

    public HeadWithHeaders(Iterable<String> headers, HttpHead origin) {
        this(origin, new Mapped<>(HeaderParsed::new, headers));
    }

    public HeadWithHeaders(HttpHead origin, Iterable<Prop> headers) {
        this.origin = origin;
        this.headers = headers;
    }

    @Override
    public HttpLine line() {
        return origin.line();
    }

    @Override
    public Iterable<Prop> headers() {
        return new Joined<>(
            origin.headers(),
            headers
        );
    }
}

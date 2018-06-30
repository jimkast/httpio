package org.jimkast.http.head;

import java.util.Arrays;
import org.cactoos.iterable.Joined;
import org.cactoos.list.Mapped;
import org.jimkast.http.HttpHead;
import org.jimkast.http.rs.RsEmpty;

public final class HeadWithHeaders implements HttpHead {
    private final HttpHead origin;
    private final Iterable<String> headers;


    public HeadWithHeaders(HttpHead origin, CharSequence... headers) {
        this(origin, new Mapped<>(CharSequence::toString, Arrays.asList(headers)));
    }

    public HeadWithHeaders(Iterable<String> headers) {
        this(new RsEmpty(), headers);
    }

    public HeadWithHeaders(HttpHead origin, Iterable<String> headers) {
        this.origin = origin;
        this.headers = headers;
    }

    @Override
    public String line() {
        return origin.line();
    }

    @Override
    public Iterable<String> headers() {
        return new Joined<>(
            origin.headers(),
            headers
        );
    }
}

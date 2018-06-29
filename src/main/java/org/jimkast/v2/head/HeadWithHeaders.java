package org.jimkast.v2.head;

import java.util.Arrays;
import org.cactoos.iterable.Joined;
import org.jimkast.v2.HttpHead;

public final class HeadWithHeaders implements HttpHead {
    private final HttpHead origin;
    private final Iterable<String> headers;

    public HeadWithHeaders(HttpHead origin, String... headers) {
        this(origin, Arrays.asList(headers));
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

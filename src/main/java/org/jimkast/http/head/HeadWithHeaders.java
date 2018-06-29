package org.jimkast.http.head;

import java.util.Arrays;
import org.cactoos.iterable.Joined;
import org.jimkast.http.HttpHead;

public final class HeadWithHeaders implements HttpHead {
    private final HttpHead origin;
    private final Iterable<String> headers;

    public HeadWithHeaders(String... headers) {
        this(Arrays.asList(headers));
    }

    public HeadWithHeaders(HttpHead origin, String... headers) {
        this(origin, Arrays.asList(headers));
    }

    public HeadWithHeaders(Iterable<String> headers) {
        this(new HeadRsEmpty(), headers);
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

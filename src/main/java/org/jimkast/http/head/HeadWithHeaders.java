package org.jimkast.http.head;

import java.util.Arrays;
import org.cactoos.iterable.Joined;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpLine;
import org.jimkast.http.rs.RsEmpty;
import org.jimkast.map.Prop;

public final class HeadWithHeaders implements HttpHead {
    private final HttpHead origin;
    private final Iterable<Prop> headers;

    public HeadWithHeaders(Prop... headers) {
        this(Arrays.asList(headers));
    }

    public HeadWithHeaders(HttpHead origin, Prop... headers) {
        this(origin, Arrays.asList(headers));
    }

    public HeadWithHeaders(Iterable<Prop> headers) {
        this(new RsEmpty(), headers);
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

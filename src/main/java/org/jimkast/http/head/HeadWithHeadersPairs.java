package org.jimkast.http.head;

import java.util.Arrays;
import org.cactoos.iterable.Joined;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpLine;
import org.jimkast.http.rs.RsEmpty;

public final class HeadWithHeadersPairs implements HttpHead {
    private final HttpHead origin;
    private final Iterable<Header> headers;

    public HeadWithHeadersPairs(Header... headers) {
        this(new RsEmpty(), headers);
    }

    public HeadWithHeadersPairs(HttpHead origin, Header... headers) {
        this(origin, Arrays.asList(headers));
    }

    public HeadWithHeadersPairs(Iterable<Header> headers) {
        this(new RsEmpty(), headers);
    }


    public HeadWithHeadersPairs(HttpHead origin, Iterable<Header> headers) {
        this.origin = origin;
        this.headers = headers;
    }

    @Override
    public HttpLine line() {
        return origin.line();
    }

    @Override
    public Iterable<Header> headers() {
        return new Joined<>(
            origin.headers(),
            headers
        );
    }
}

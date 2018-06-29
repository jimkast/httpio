package org.jimkast.http.head;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import org.cactoos.collection.CollectionOf;
import org.cactoos.iterable.Filtered;
import org.jimkast.text.SubstringBefore;
import org.jimkast.http.HttpHead;

public final class HeadWithoutHeaders implements HttpHead {
    private final HttpHead origin;
    private final Predicate<String> headers;

    public HeadWithoutHeaders(HttpHead origin, String... headers) {
        this(origin, Arrays.asList(headers));
    }

    public HeadWithoutHeaders(HttpHead origin, Iterable<String> headers) {
        this(origin, new CollectionOf<>(headers));
    }

    public HeadWithoutHeaders(HttpHead origin, Collection<String> headers) {
        this(origin, headers::contains);
    }

    public HeadWithoutHeaders(HttpHead origin, Predicate<String> headers) {
        this.origin = origin;
        this.headers = headers;
    }

    @Override
    public String line() {
        return origin.line();
    }

    @Override
    public Iterable<String> headers() {
        return new Filtered<>(
            input -> !headers.test(new SubstringBefore(input, ":").toString()),
            origin.headers()
        );
    }
}

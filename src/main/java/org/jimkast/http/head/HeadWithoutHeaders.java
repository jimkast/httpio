package org.jimkast.http.head;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import org.cactoos.collection.CollectionOf;
import org.cactoos.iterable.Filtered;
import org.jimkast.http.Header;
import org.jimkast.http.HttpHead;

public final class HeadWithoutHeaders implements HttpHead {
    private final HttpHead origin;
    private final Predicate<String> check;

    public HeadWithoutHeaders(HttpHead origin, String... check) {
        this(origin, Arrays.asList(check));
    }

    public HeadWithoutHeaders(HttpHead origin, Iterable<String> check) {
        this(origin, new CollectionOf<>(check));
    }

    public HeadWithoutHeaders(HttpHead origin, Collection<String> check) {
        this(origin, check::contains);
    }

    public HeadWithoutHeaders(HttpHead origin, Predicate<String> check) {
        this.origin = origin;
        this.check = check;
    }

    @Override
    public String line() {
        return origin.line();
    }

    @Override
    public Iterable<Header> headers() {
        return new Filtered<>(
            h -> !check.test(h.name()),
            origin.headers()
        );
    }
}

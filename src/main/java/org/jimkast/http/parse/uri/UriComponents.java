package org.jimkast.http.parse.uri;

import java.util.Arrays;
import org.cactoos.list.Mapped;
import org.cactoos.scalar.StickyScalar;
import org.jimkast.http.HttpHead;
import org.jimkast.http.parse.params.TextUrlDecoded;
import org.jimkast.iterable.ListEnvelope;

public final class UriComponents extends ListEnvelope<String> {
    public UriComponents(HttpHead req) {
        this(new UriPath(req));
    }

    public UriComponents(CharSequence uri) {
        super(new StickyScalar<>(() -> new Mapped<>(
            p -> new TextUrlDecoded(p).toString(),
            Arrays.asList(new UriPath(uri).toString().split("/"))
        )));
    }
}

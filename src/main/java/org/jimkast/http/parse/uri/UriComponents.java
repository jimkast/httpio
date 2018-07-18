package org.jimkast.http.parse.uri;

import java.net.URLDecoder;
import java.util.Arrays;
import org.cactoos.list.Mapped;
import org.cactoos.scalar.StickyScalar;
import org.jimkast.http.HttpHead;
import org.jimkast.iterable.ListEnvelope;

public final class UriComponents extends ListEnvelope<String> {
    public UriComponents(HttpHead req) {
        this(new UriPath(req));
    }

    public UriComponents(CharSequence uri) {
        super(new StickyScalar<>(() -> new Mapped<>(
            i -> URLDecoder.decode(i, "UTF-8"),
            Arrays.asList(new UriPath(uri).toString().split("/"))
        )));
    }
}

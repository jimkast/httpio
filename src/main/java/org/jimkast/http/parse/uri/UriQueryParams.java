package org.jimkast.http.parse.uri;

import java.util.Map;
import org.jimkast.http.HttpHead;
import org.jimkast.http.parse.line.RqURI;
import org.jimkast.http.parse.params.FormDecodedParams;
import org.jimkast.iterable.IterableEnvelope;

public final class UriQueryParams extends IterableEnvelope<Map.Entry<String, String>> {
    public UriQueryParams(HttpHead uri) {
        this(new RqURI(uri));
    }

    public UriQueryParams(CharSequence uri) {
        super(new FormDecodedParams(new UriQueryString(uri)));
    }
}

package org.jimkast.http.parse.params;

import org.jimkast.http.HttpIn;
import org.jimkast.http.parse.header.HttpCharset;
import org.jimkast.http.parse.header.HttpSafeCharset;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.Prop;

public final class FormBodyDecodedParams extends IterableEnvelope<Prop> {
    public FormBodyDecodedParams(HttpIn req) {
        super(
            new FormDecodedParams(
                new HttpSafeCharset(
                    new HttpCharset(req, "UTF-8")
                ),
                req
            )
        );
    }
}

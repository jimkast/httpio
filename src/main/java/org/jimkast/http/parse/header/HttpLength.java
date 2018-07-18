package org.jimkast.http.parse.header;


import org.jimkast.http.HttpHead;
import org.jimkast.http.rs.HttpHeaderValue;
import org.jimkast.number.LongParsed;
import org.jimkast.number.NumberEnvelope;

public final class HttpLength extends NumberEnvelope {
    public HttpLength(HttpHead msg) {
        super(new LongParsed(
            new HttpHeaderValue(
                msg,
                "Content-Length",
                "-1"
            )
        ));
    }

}

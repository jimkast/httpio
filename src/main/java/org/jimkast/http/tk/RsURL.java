package org.jimkast.http.tk;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import org.cactoos.Scalar;
import org.cactoos.scalar.StickyScalar;
import org.jimkast.http.Header;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeadersPairs;
import org.jimkast.http.rs.RsInput;
import org.jimkast.text.TextEnvelope;

public final class RsURL extends HttpOut.Envelope {
    public RsURL(CharSequence url) {
        this(new StickyScalar<>(() -> new URL(url.toString()).openConnection()));
    }

    public RsURL(URI uri) {
        this(new StickyScalar<>(() -> uri.toURL().openConnection()));
    }

    public RsURL(URL url) {
        this(new StickyScalar<>(url::openConnection));
    }

    public RsURL(Scalar<URLConnection> conn) {
        super(
            new RsInput(
                () -> conn.value().getInputStream(),
                new HeadWithHeadersPairs(
                    new Header.Simple(
                        "Last-Modified",
                        new TextEnvelope(() -> new Date(conn.value().getLastModified()).toInstant().toString())
                    )
                )
            )
        );
    }
}

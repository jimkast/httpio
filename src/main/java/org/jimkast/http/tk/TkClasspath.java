package org.jimkast.http.tk;

import java.net.URL;
import java.net.URLConnection;
import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.http.parse.RqURI;
import org.jimkast.http.route.TkNotFound;
import org.jimkast.http.rs.RsBasic;
import org.jimkast.io.bs.BsInput;
import org.jimkast.text.Concat;
import org.jimkast.text.TextEnvelope;

public final class TkClasspath implements HttpServerMapping {
    private final HttpServerMapping notFound;

    public TkClasspath() {
        this(new TkNotFound());
    }

    public TkClasspath(HttpOut notFound) {
        this(new TkFixed(notFound));
    }

    public TkClasspath(HttpServerMapping notFound) {
        this.notFound = notFound;
    }

    @Override
    public HttpOut exchange(HttpIn in) {
        HttpOut res;
        URL url = this.getClass().getClassLoader().getResource(new RqURI(in).toString());
        if (url == null) {
            res = notFound.exchange(in);
        } else {
            UncheckedScalar<URLConnection> conn = new UncheckedScalar<>(new StickyScalar<>(url::openConnection));
            res = new RsBasic(
                new HeadWithHeaders(new Concat("Content-Length: ", new TextEnvelope(() -> String.valueOf(conn.value().getContentLength())))),
                new BsInput(() -> conn.value().getInputStream())
            );
        }
        return res;

    }
}

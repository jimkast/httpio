package org.jimkast.http.tk;

import java.net.URL;
import java.net.URLConnection;
import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.http.parse.line.RqURI;
import org.jimkast.http.rs.RsBasic;
import org.jimkast.io.bs.BsInput;
import org.jimkast.map.prop.PropSimple;

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
                new HeadWithHeaders(new PropSimple("Content-Length", String.valueOf(conn.value().getContentLength()))),
                new BsInput(() -> conn.value().getInputStream())
            );
        }
        return res;

    }
}

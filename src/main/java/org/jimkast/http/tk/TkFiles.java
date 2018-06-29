package org.jimkast.http.tk;

import java.io.File;
import org.cactoos.io.InputOf;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.body.RsBasic;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.http.route.RouteNotFound;
import org.jimkast.http.rq.RqUri;

public final class TkFiles implements HttpServerMapping {
    private final File root;
    private final HttpServerMapping notFound;

    public TkFiles(File root) {
        this(root, new RouteNotFound());
    }

    public TkFiles(File root, HttpOut notFound) {
        this(root, new TkFixed(notFound));
    }

    public TkFiles(File root, HttpServerMapping notFound) {
        this.root = root;
        this.notFound = notFound;
    }

    @Override
    public HttpOut exchange(HttpIn in) {
        File file = new File(root, new RqUri(in).toString());
        return file.exists() ?
            new RsBasic(
                new HeadWithHeaders("Content-Length: " + file.length()),
                new InputOf(file)
            ) : notFound.exchange(in);
    }
}

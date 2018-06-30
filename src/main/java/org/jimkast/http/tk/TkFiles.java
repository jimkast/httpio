package org.jimkast.http.tk;

import java.io.File;
import org.cactoos.io.InputOf;
import org.jimkast.bytes.InputAsByteSource;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.route.TkNotFound;
import org.jimkast.http.rq.RqUri;
import org.jimkast.http.rs.RsBasic;
import org.jimkast.http.rs.RsWithHeaders;

public final class TkFiles implements HttpServerMapping {
    private final File root;
    private final HttpServerMapping notFound;

    public TkFiles(File root) {
        this(root, new TkNotFound());
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
                new RsWithHeaders("Content-Length: " + file.length()),
                new InputAsByteSource(new InputOf(file))
            ) : notFound.exchange(in);
    }
}

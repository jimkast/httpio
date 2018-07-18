package org.jimkast.http.tk;

import java.nio.file.Files;
import java.nio.file.Path;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.parse.uri.UriPath;
import org.jimkast.http.route.TkNotFound;
import org.jimkast.map.Mapping;

public final class TkFiles implements HttpServerMapping {
    private final Mapping<String, Path> mapping;
    private final HttpServerMapping notFound;

    public TkFiles(Path root) {
        this(root, new TkNotFound());
    }

    public TkFiles(Path root, HttpOut notFound) {
        this(root, new TkFixed(notFound));
    }

    public TkFiles(Path root, HttpServerMapping notFound) {
        this(root::resolve, notFound);
    }

    public TkFiles(Mapping<String, Path> mapping, HttpServerMapping notFound) {
        this.mapping = mapping;
        this.notFound = notFound;
    }

    @Override
    public HttpOut exchange(HttpIn in) {
        Path file = mapping.map(new UriPath(in).toString().substring(1));
        return Files.exists(file) ? new RsFile(file) : notFound.exchange(in);
    }
}

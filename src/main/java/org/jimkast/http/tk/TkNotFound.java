package org.jimkast.http.tk;

import java.io.UncheckedIOException;
import org.jimkast.http.HttpException;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpRoute;
import org.jimkast.http.HttpServerMapping;

public final class TkNotFound implements HttpRoute, HttpServerMapping {
    @Override
    public boolean test(HttpHead head) {
        return false;
    }

    @Override
    public HttpServerMapping map() {
        throw new UncheckedIOException(new HttpException(404, "Route not found."));
    }

    @Override
    public HttpOut exchange(HttpIn in) {
        throw new UncheckedIOException(new HttpException(404, "Route not found."));
    }
}

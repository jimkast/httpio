package org.jimkast.http.tk;

import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.HttpServerMapping;

public final class TkFixed implements HttpServerMapping {
    private final HttpOut response;

    public TkFixed(HttpOut response) {
        this.response = response;
    }

    @Override
    public HttpOut exchange(HttpIn in) {
        return response;
    }
}

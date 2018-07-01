package org.jimkast.http.adapters;

import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.jimkast.http.HttpServerMapping;

public final class SunHandler implements HttpHandler {
    private final HttpServerMapping mapping;

    public SunHandler(HttpServerMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        new RsSun(mapping.exchange(new RqSun(exchange))).apply(exchange);
    }
}

package org.jimkast.http.adapters;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import org.jimkast.http.HttpServerMapping;

public final class UndertowTakeHandler implements HttpHandler {
    private final HttpServerMapping mapping;

    public UndertowTakeHandler(HttpServerMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        new RsUndertow(mapping.exchange(new RqUndertow(exchange))).apply(exchange);
    }
}

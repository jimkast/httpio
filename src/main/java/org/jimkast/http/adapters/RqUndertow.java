package org.jimkast.http.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HeaderValues;
import org.jimkast.http.HttpIn;

public final class RqUndertow implements HttpIn {
    private final HttpServerExchange exchange;

    public RqUndertow(HttpServerExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public String line() {
        String q = exchange.getQueryString();
        return String.join(
            " ",
            exchange.getRequestMethod().toString(),
            exchange.getRequestURI() + (q == null || q.isEmpty() ? "" : "?" + q),
            exchange.getProtocol().toString()
        );
    }

    @Override
    public Iterable<String> headers() {
        List<String> headers = new ArrayList<>();
        for (HeaderValues header : exchange.getRequestHeaders()) {
            String name = header.getHeaderName().toString();
            for (String value : header) {
                headers.add(name + ": " + value);
            }
        }
        return headers;
    }

    @Override
    public InputStream stream() throws IOException {
        return exchange.getInputStream();
    }
}

package org.jimkast.http.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HeaderValues;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpLine;
import org.jimkast.io.InputStreamNoClose;

public final class RqUndertow implements HttpIn {
    private final HttpServerExchange exchange;

    public RqUndertow(HttpServerExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public HttpLine line() {
        String q = exchange.getQueryString();
        return new HttpLine.Raw(
            exchange.getRequestMethod().toString(),
            exchange.getRequestURI() + (q == null || q.isEmpty() ? "" : "?" + q),
            exchange.getProtocol().toString()
        );
    }

    @Override
    public Iterable<Header> headers() {
        List<Header> headers = new ArrayList<>();
        for (HeaderValues header : exchange.getRequestHeaders()) {
            String name = header.getHeaderName().toString();
            for (String value : header) {
                headers.add(new Header.Simple(name, value));
            }
        }
        return headers;
    }

    @Override
    public InputStream stream() throws IOException {
        return new InputStreamNoClose(exchange.getInputStream());
    }
}

package org.jimkast.http.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpLine;

public final class RqSun implements HttpIn {
    private final HttpExchange exchange;

    public RqSun(HttpExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public HttpLine line() {
        return new HttpLine.Raw(
            exchange.getRequestMethod(),
            exchange.getRequestURI().toString(),
            exchange.getProtocol()
        );
    }

    @Override
    public Iterable<Header> headers() {
        List<Header> result = new ArrayList<>();
        Map<String, List<String>> headers = exchange.getRequestHeaders();
        for (String name : exchange.getRequestHeaders().keySet()) {
            for (String value : headers.get(name)) {
                result.add(new Header.Simple(name, value));
            }
        }
        return result;
    }

    @Override
    public InputStream stream() throws IOException {
        return exchange.getRequestBody();
    }
}

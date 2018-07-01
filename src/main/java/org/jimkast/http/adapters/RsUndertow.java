package org.jimkast.http.adapters;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import org.cactoos.Func;
import org.jimkast.http.HttpOut;
import org.jimkast.http.rs.RsStatus;
import org.jimkast.io.OutputStreamNoClose;

public final class RsUndertow implements Func<HttpServerExchange, HttpServerExchange> {
    private final HttpOut res;

    public RsUndertow(HttpOut res) {
        this.res = res;
    }

    @Override
    public HttpServerExchange apply(HttpServerExchange exchange) throws Exception {
        exchange.setStatusCode(new RsStatus(res).intValue());
        for (String s : res.headers()) {
            String[] parts = s.split(":", 2);
            exchange.getResponseHeaders().add(HttpString.tryFromString(parts[0].trim()), parts[1].trim());
        }
        res.print(new OutputStreamNoClose(exchange.getOutputStream()));
        return exchange;
    }
}

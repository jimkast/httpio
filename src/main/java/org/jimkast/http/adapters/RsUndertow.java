package org.jimkast.http.adapters;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import org.cactoos.Func;
import org.jimkast.http.Header;
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
        for (Header h : res.headers()) {
            exchange.getResponseHeaders().add(HttpString.tryFromString(h.name()), h.value());
        }
        res.print(new OutputStreamNoClose(exchange.getOutputStream()));
        return exchange;
    }
}

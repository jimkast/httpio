package org.jimkast.http.adapters;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.cactoos.Func;
import org.jimkast.http.HttpOut;
import org.jimkast.http.rs.HttpLength;
import org.jimkast.http.rs.RsStatus;

public final class RsSun implements Func<HttpExchange, HttpExchange> {
    private final HttpOut out;

    public RsSun(HttpOut out) {
        this.out = out;
    }

    @Override
    public HttpExchange apply(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        for (String h : out.headers()) {
            String[] parts = h.split(":", 2);
            String name = parts[0].trim();
            String value = parts[1].trim();
            headers.computeIfAbsent(name, s -> new ArrayList<>()).add(value);
        }
        int status = new RsStatus(out).intValue();
        long len = new HttpLength(out).longValue();
        if (len == -1) {
            exchange.sendResponseHeaders(status, 0);
        } else {
            exchange.sendResponseHeaders(status, len);
        }
        OutputStream output = exchange.getResponseBody();
        out.print(output);
        output.close();
        return exchange;
    }
}

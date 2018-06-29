package org.jimkast.bk;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.jimkast.bytes.BytesSource;
import org.jimkast.http.Header;
import org.jimkast.http.HeaderParts;
import org.jimkast.http.HttpInput;
import org.jimkast.http.HttpServer;
import org.takes.Request;
import org.takes.rq.RqLive;

public final class BkHttp implements BytesExchange {
    private final HttpServer exchange;

    public BkHttp(HttpServer exchange) {
        this.exchange = exchange;
    }

    @Override
    public BytesSource exchange(InputStream input) throws IOException {
        Request req = new RqLive(input);
        String line = "";
        List<Header> headers = new ArrayList<>();
        boolean first = true;
        for (String s : req.head()) {
            if(first) {
                first = false;
                line = s;
            } else {
                String[] parts = s.split(":", 2);
                headers.add(new HeaderParts(parts[0], parts[1]));
            }
        }
        String l = line;
        return exchange.respond(new HttpInput() {
            @Override
            public Text line() {
                return new TextOf(l);
            }

            @Override
            public Iterable<Header> headers() {
                return headers;
            }

            @Override
            public InputStream stream() throws Exception {
                return input;
            }
        });
    }
}

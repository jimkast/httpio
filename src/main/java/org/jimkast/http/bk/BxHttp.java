package org.jimkast.http.bk;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.cactoos.io.InputOf;
import org.jimkast.bytes.BytesSource;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.rq.RqBasic;
import org.takes.Request;
import org.takes.rq.RqLive;

public final class BxHttp implements BytesExchange {
    private final HttpServerMapping exchange;

    public BxHttp(HttpServerMapping exchange) {
        this.exchange = exchange;
    }

    @Override
    public BytesSource exchange(InputStream input) throws IOException {
        Request req = new RqLive(input);
        String line = "";
        List<String> headers = new ArrayList<>();
        boolean first = true;
        for (String s : req.head()) {
            if (first) {
                first = false;
                line = s;
            } else {
                headers.add(s);
            }
        }
        return new BsHttpOutFull(
            exchange.exchange(
                new RqBasic(
                    line,
                    headers,
                    new InputOf(input)
                )
            )
        );
    }
}

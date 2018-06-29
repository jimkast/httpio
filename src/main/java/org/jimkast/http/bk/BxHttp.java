package org.jimkast.http.bk;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.jimkast.bytes.BytesSource;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpServerMapping;
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
            if(first) {
                first = false;
                line = s;
            } else {
                headers.add(s);
            }
        }
        String l = line;
        HttpHead head = new HttpHead() {
            @Override
            public String line() {
                return l;
            }

            @Override
            public Iterable<String> headers() {
                return headers;
            }
        };
        return new BsHttpOutFull(exchange.exchange(
            new HttpIn() {
                @Override
                public HttpHead head() {
                    return head;
                }

                @Override
                public InputStream stream() {
                    return input;
                }
            }
        ));
    }
}

package org.jimkast.http.bk;

import java.io.IOException;
import java.io.InputStream;
import org.cactoos.io.InputOf;
import org.cactoos.iterable.Skipped;
import org.cactoos.list.Mapped;
import org.jimkast.bytes.BytesSource;
import org.jimkast.http.Header;
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
        return new BsHttpOutFull(
            exchange.exchange(
                new RqBasic(
                    req.head().iterator().next(),
                    new Mapped<>(Header.Parsed::new, new Skipped<>(req.head(), 1)),
                    new InputOf(input)
                )
            )
        );
    }
}

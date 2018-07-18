package org.jimkast.net.bk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.cactoos.io.InputOf;
import org.cactoos.iterable.IterableOf;
import org.cactoos.list.Mapped;
import org.jimkast.http.HttpLine;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.head.HeadBasic;
import org.jimkast.http.head.HeaderParsed;
import org.jimkast.http.rq.RqBasic;
import org.jimkast.io.BytesSource;
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
        Iterator<String> iter = req.head().iterator();
        return new BsHttpOutFull(
            exchange.exchange(
                new RqBasic(
                    new HeadBasic(
                        new HttpLine.Raw(iter.next()),
                        new Mapped<>(HeaderParsed::new, new IterableOf<>(iter))
                    ),
                    new InputOf(input)
                )
            )
        );
    }
}

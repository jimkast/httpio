package org.jimkast.http.wire;

import java.io.IOException;
import org.jimkast.http.bk.BytesExchange;

public final class SessionRsRq implements Session {
    private final BytesExchange exchange;

    public SessionRsRq(BytesExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void accept(Connection channel) throws IOException {
        exchange.exchange(channel.in()).print(channel.out());
    }
}

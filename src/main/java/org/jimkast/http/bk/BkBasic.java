package org.jimkast.http.bk;

import java.io.IOException;
import java.net.Socket;
import org.takes.http.Back;

public final class BkBasic implements Back {
    private final BytesExchange exchange;

    public BkBasic(BytesExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void accept(Socket socket) throws IOException {
        exchange.exchange(socket.getInputStream()).print(socket.getOutputStream());
    }
}

package org.jimkast.bk;

import java.io.IOException;
import java.net.Socket;

public final class BkSocketBasic implements SocketServer {
    private final BytesExchange exchange;

    public BkSocketBasic(BytesExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void accept(Socket socket) throws IOException {
        exchange.exchange(socket.getInputStream()).print(socket.getOutputStream());
    }
}

package org.jimkast.http.wire;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;

public final class SrvBasic implements Server {
    private final ServerSocket socket;

    public SrvBasic(ServerSocket socket) {
        this.socket = socket;
    }

    @Override
    public Connection accept() throws IOException {
        while (true) {
            try {
                return new SocketChannel(socket.accept());
            } catch (final SocketTimeoutException ignored) {
            }
        }

    }
}

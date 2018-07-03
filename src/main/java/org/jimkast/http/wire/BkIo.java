package org.jimkast.http.wire;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class BkIo implements Back {
    private final ServerSocket socket;

    public BkIo(int port) throws IOException {
        this(new ServerSocket(port));
    }

    public BkIo(ServerSocket socket) {
        this.socket = socket;
    }

    @Override
    public void trigger(Session session) throws IOException {
        try {
            while (true) {
                try (Socket s = socket.accept()) {
                    session.consume(new ConnSocket(s));
                }
            }
        } finally {
            socket.close();
        }
    }
}

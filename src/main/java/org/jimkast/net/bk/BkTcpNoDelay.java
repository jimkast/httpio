package org.jimkast.net.bk;

import java.io.IOException;
import java.net.Socket;
import org.takes.http.Back;

public final class BkTcpNoDelay implements Back {
    private final Back origin;

    public BkTcpNoDelay(Back origin) {
        this.origin = origin;
    }

    @Override
    public void accept(Socket socket) throws IOException {
        socket.setTcpNoDelay(true);
        origin.accept(socket);
    }
}

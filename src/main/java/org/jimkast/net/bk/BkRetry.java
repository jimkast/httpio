package org.jimkast.net.bk;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.takes.http.Back;

public final class BkRetry implements Back {
    private final Back origin;

    public BkRetry(int timeout, Back origin) {
        this(new BkWithTimeout(timeout, origin));
    }

    public BkRetry(Back origin) {
        this.origin = origin;
    }

    @Override
    public void accept(Socket socket) throws IOException {
        while (true) {
            try {
                origin.accept(socket);
            } catch (SocketTimeoutException e) {
                if(!socket.isClosed()) {
                    socket.close();
                }
                break;
            }
        }
    }
}

package org.jimkast.net.bk;

import java.io.IOException;
import java.net.Socket;
import org.takes.http.Back;

public final class BkWithTimeout implements Back {
    private final Number millis;
    private final Back origin;

    public BkWithTimeout(Number millis, Back origin) {
        this.millis = millis;
        this.origin = origin;
    }

    @Override
    public void accept(Socket socket) throws IOException {
        socket.setSoTimeout(millis.intValue());
        origin.accept(socket);
    }
}

package org.jimkast.net.bk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.takes.http.Back;

public final class BkCloseStreams implements Back {
    private final Back origin;

    public BkCloseStreams(Back origin) {
        this.origin = origin;
    }

    @Override
    public void accept(Socket socket) throws IOException {
        try (InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream()){
            origin.accept(socket);
        }
    }
}

package org.jimkast.net.wire;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class ConnSocket implements Connection {
    private final Socket socket;

    public ConnSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public InputStream in() throws IOException {
        return socket.getInputStream();
    }

    @Override
    public OutputStream out() throws IOException {
        return socket.getOutputStream();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}

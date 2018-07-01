package org.jimkast.http.wire;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class SocketChannel implements Connection {
    private final Socket socket;

    public SocketChannel(Socket socket) {
        this.socket = socket;
    }

    @Override
    public InputStream input() throws IOException {
        return socket.getInputStream();
    }

    @Override
    public OutputStream output() throws IOException {
        return socket.getOutputStream();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}

package org.jimkast.bk;

import java.io.IOException;
import java.net.Socket;

public interface SocketServer {
    void accept(Socket socket) throws IOException;
}

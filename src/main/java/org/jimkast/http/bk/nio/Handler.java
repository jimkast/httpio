package org.jimkast.http.bk.nio;

import java.io.IOException;
import java.net.Socket;

public interface Handler {
    boolean handleConnection(Socket client) throws IOException;
}

package org.jimkast.http.bk.nio;

import org.apache.mina.transport.nio.NioTcpServer;

public final class BkMina implements Runnable {
    @Override
    public void run() {
        new NioTcpServer();
    }
}

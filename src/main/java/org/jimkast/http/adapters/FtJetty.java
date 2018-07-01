package org.jimkast.http.adapters;

import java.io.IOException;
import org.eclipse.jetty.server.Server;
import org.jimkast.http.HttpServerMapping;
import org.takes.http.Exit;
import org.takes.http.Front;

public final class FtJetty implements Front {
    private final Number port;
    private final JettyHandler handler;

    public FtJetty(Number port, HttpServerMapping mapping) {
        this(port, new JettyHandler(mapping));
    }

    public FtJetty(Number port, JettyHandler handler) {
        this.port = port;
        this.handler = handler;
    }

    @Override
    public void start(Exit exit) throws IOException {
        Server server = new Server(port.intValue());
        server.setHandler(handler);
        try {
            server.start();
            server.join();
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException(e);
        }

    }
}

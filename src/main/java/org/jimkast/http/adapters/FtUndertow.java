package org.jimkast.http.adapters;

import java.io.IOException;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.BlockingHandler;
import org.jimkast.http.HttpServerMapping;
import org.takes.http.Exit;
import org.takes.http.Front;

public final class FtUndertow implements Front {
    private final Number port;
    private final HttpHandler handler;

    public FtUndertow(Number port, HttpServerMapping mapping) {
        this(port, new BlockingHandler(new UndertowTakeHandler(mapping)));
    }

    public FtUndertow(Number port, HttpHandler handler) {
        this.port = port;
        this.handler = handler;
    }

    @Override
    public void start(Exit exit) throws IOException {
        Undertow server = Undertow.builder()
            .addHttpListener(port.intValue(), "localhost")
            .setHandler(handler).build();
        server.start();
    }
}

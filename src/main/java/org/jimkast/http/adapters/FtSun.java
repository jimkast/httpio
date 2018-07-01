package org.jimkast.http.adapters;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.jimkast.http.HttpServerMapping;
import org.takes.http.Exit;
import org.takes.http.Front;

public final class FtSun implements Front {
    private final Number port;
    private final ExecutorService executor;
    private final HttpHandler handler;

    public FtSun(Number port, HttpServerMapping mapping) {
        this(port, null, new SunHandler(mapping));
    }

    public FtSun(Number port, int threads, HttpServerMapping mapping) {
        this(port, Executors.newFixedThreadPool(threads), mapping);
    }

    public FtSun(Number port, ExecutorService executor, HttpServerMapping mapping) {
        this(port, executor, new SunHandler(mapping));
    }

    public FtSun(Number port, ExecutorService executor, HttpHandler handler) {
        this.port = port;
        this.executor = executor;
        this.handler = handler;
    }

    @Override
    public void start(Exit exit) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port.intValue()), 0);
        server.createContext("/", handler);
        server.setExecutor(executor);
        server.start();
    }
}

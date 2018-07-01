package org.jimkast.http.adapters;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.rq.RqCachedHead;

public final class JettyHandler extends AbstractHandler {
    private final HttpServerMapping mapping;

    public JettyHandler(HttpServerMapping mapping) {
        this.mapping = mapping;
    }

    public void handle(String target, Request baseRequest, HttpServletRequest req, HttpServletResponse res) throws IOException {
        new RsServlet(mapping.exchange(new RqCachedHead(new RqServlet(req)))).apply(res);
        baseRequest.setHandled(true);
    }
}
package org.jimkast.http.adapters;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.rq.RqCachedHead;

public final class ServletHandler extends HttpServlet {
    private final HttpServerMapping mapping;

    public ServletHandler(HttpServerMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        new RsServlet(mapping.exchange(new RqCachedHead(new RqServlet(req)))).apply(res);
    }
}

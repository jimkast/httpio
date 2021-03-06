package org.jimkast.http.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpLine;
import org.jimkast.map.Prop;
import org.jimkast.map.prop.PropSimple;

public final class RqServlet implements HttpIn {
    private final HttpServletRequest req;

    public RqServlet(HttpServletRequest req) {
        this.req = req;
    }

    @Override
    public HttpLine line() {
        String q = req.getQueryString();
        return new HttpLine.Raw(
            req.getMethod(),
            req.getRequestURI() + (q == null ? "" : "?" + q),
            req.getProtocol()
        );
    }

    @Override
    public Iterable<Prop> headers() {
        List<Prop> headers = new ArrayList<>();
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            Enumeration<String> headerValues = req.getHeaders(name);
            while (headerValues.hasMoreElements()) {
                headers.add(new PropSimple(name, headerValues.nextElement()));
            }
        }
        headers.add(new PropSimple("X-Meta-LocalAddress", req.getLocalAddr()));
        headers.add(new PropSimple("X-Meta-LocalPort", String.valueOf(req.getLocalPort())));
        headers.add(new PropSimple("X-Meta-RemoteAddress", req.getRemoteAddr()));
        return headers;
    }

    @Override
    public InputStream stream() throws IOException {
        return req.getInputStream();
    }
}

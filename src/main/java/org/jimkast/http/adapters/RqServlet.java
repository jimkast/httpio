package org.jimkast.http.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jimkast.http.Header;
import org.jimkast.http.HttpIn;

public final class RqServlet implements HttpIn {
    private final HttpServletRequest req;

    public RqServlet(HttpServletRequest req) {
        this.req = req;
    }

    @Override
    public Iterable<String> line() {
        String q = req.getQueryString();
        return Arrays.asList(
            req.getMethod(),
            req.getRequestURI() + (q == null ? "" : "?" + q),
            req.getProtocol()
        );
    }

    @Override
    public Iterable<Header> headers() {
        List<Header> headers = new ArrayList<>();
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            Enumeration<String> headerValues = req.getHeaders(name);
            while (headerValues.hasMoreElements()) {
                headers.add(new Header.Simple(name, headerValues.nextElement()));
            }
        }
        headers.add(new Header.Simple("X-Takes-LocalAddress", req.getLocalAddr()));
        headers.add(new Header.Simple("X-Takes-LocalPort", String.valueOf(req.getLocalPort())));
        headers.add(new Header.Simple("X-Takes-RemoteAddress", req.getRemoteAddr()));
        return headers;
    }

    @Override
    public InputStream stream() throws IOException {
        return req.getInputStream();
    }
}

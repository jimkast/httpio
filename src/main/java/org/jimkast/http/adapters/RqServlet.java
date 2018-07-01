package org.jimkast.http.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jimkast.http.HttpIn;

public final class RqServlet implements HttpIn {
    private final HttpServletRequest req;

    public RqServlet(HttpServletRequest req) {
        this.req = req;
    }

    @Override
    public String line() {
        String q = req.getQueryString();
        return String.join(
            " ",
            req.getMethod(),
            req.getRequestURI() + (q == null ? "" : "?" + q),
            req.getProtocol()
        );
    }

    @Override
    public Iterable<String> headers() {
        List<String> headers = new ArrayList<>();
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            Enumeration<String> headerValues = req.getHeaders(name);
            while (headerValues.hasMoreElements()) {
                headers.add(name + ": " + headerValues.nextElement());
            }
        }
        return headers;
    }

    @Override
    public InputStream stream() throws IOException {
        return req.getInputStream();
    }
}

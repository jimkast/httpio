package org.jimkast.net.bk.wire;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpOut;
import org.jimkast.http.adapters.RqServlet;
import org.jimkast.http.adapters.RsServlet;
import org.jimkast.http.rq.RqCachedHead;

public final class CodecServlet implements HttpCodec {
    private final HttpServletRequest req;
    private final HttpServletResponse res;

    public CodecServlet(HttpServletRequest req, HttpServletResponse res) {
        this.req = req;
        this.res = res;
    }

    @Override
    public HttpIn read() throws IOException {
        return new RqCachedHead(new RqServlet(req));
    }

    @Override
    public HttpCodec write(HttpOut out) throws IOException {
        new RsServlet(out).apply(res);
        return this;
    }
}

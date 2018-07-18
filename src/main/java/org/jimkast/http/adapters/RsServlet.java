package org.jimkast.http.adapters;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.cactoos.Func;
import org.jimkast.http.HttpOut;
import org.jimkast.http.rs.RsStatus;
import org.jimkast.map.Prop;

public final class RsServlet implements Func<HttpServletResponse, HttpServletResponse> {
    private final HttpOut out;

    public RsServlet(HttpOut out) {
        this.out = out;
    }

    @Override
    public HttpServletResponse apply(HttpServletResponse res) throws IOException {
        res.setStatus(new RsStatus(out).intValue());
        for (Prop s : out.headers()) {
            res.addHeader(s.name(), s.value());
        }
        out.print(res.getOutputStream());
        res.getOutputStream().flush();
        return res;
    }
}

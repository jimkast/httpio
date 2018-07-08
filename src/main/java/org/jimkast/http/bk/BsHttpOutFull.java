package org.jimkast.http.bk;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.io.BytesSource;
import org.jimkast.http.HttpOut;

public final class BsHttpOutFull implements BytesSource {
    private final HttpOut res;

    public BsHttpOutFull(HttpOut res) {
        this.res = res;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        new BsHttpHead(res).print(out);
        res.print(out);
        out.flush();
        return 0;
    }
}

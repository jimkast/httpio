package org.jimkast.http.bk;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.bytes.BytesSource;
import org.jimkast.http.HttpOut;

public final class BsHttpOutFull implements BytesSource {
    private final HttpOut res;

    public BsHttpOutFull(HttpOut res) {
        this.res = res;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        new BsHttpHead(res.head()).print(out);
        res.print(out);
        return 0;
    }
}

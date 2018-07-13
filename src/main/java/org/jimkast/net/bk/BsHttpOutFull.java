package org.jimkast.net.bk;

import org.jimkast.http.HttpOut;
import org.jimkast.io.BytesSource;
import org.jimkast.io.bs.BsAll;

public final class BsHttpOutFull extends BytesSource.Envelope {
    public BsHttpOutFull(HttpOut res) {
        super(
            new BsAll(
                new BsHttpHead(res),
                res
            )
        );
    }

}

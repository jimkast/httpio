package org.jimkast.http.rs;

import org.jimkast.http.HttpOut;
import org.jimkast.http.body.RsBasic;
import org.jimkast.http.head.HeadRsEmpty;

public final class RsEmpty extends HttpOut.Envelope {
    public RsEmpty() {
        super(new RsBasic(new HeadRsEmpty()));
    }
}

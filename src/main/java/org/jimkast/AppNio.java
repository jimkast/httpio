package org.jimkast;

import java.io.IOException;
import org.jimkast.net.bk.BxHttp;
import org.jimkast.net.wire.SessionRsRq;
import org.jimkast.net.wire.sun.FtSun;

public final class AppNio {
    public static void main(String... args) throws IOException {
        new FtSun(9999).feed(
//            new SessionParallel(
//                10,
                new SessionRsRq(
                    new BxHttp(
                        new TkApp()
                    )
//                )
            )
        );
    }
}

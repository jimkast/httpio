package org.jimkast;

import java.io.IOException;
import org.jimkast.http.bk.BxHttp;
import org.jimkast.http.wire.SessionRsRq;
import org.jimkast.http.wire.sun.FtSun;

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

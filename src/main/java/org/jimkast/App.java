package org.jimkast;

import java.io.IOException;
import org.jimkast.net.bk.BkBasic;
import org.jimkast.net.bk.BkCloseStreams;
import org.jimkast.net.bk.BkRetry;
import org.jimkast.net.bk.BkTcpNoDelay;
import org.jimkast.net.bk.BxBuffered;
import org.jimkast.net.bk.BxHttp;
import org.takes.http.BkParallel;
import org.takes.http.BkTimeable;
import org.takes.http.Exit;
import org.takes.http.FtBasic;

public final class App {
    public static void main(String... args) throws IOException {
        new FtBasic(
            new BkParallel(
                new BkTimeable(
//                    new BkSafe(
                    new BkTcpNoDelay(
                        new BkCloseStreams(
                            new BkRetry(5000,
                                new BkBasic(
                                    new BxBuffered(
                                        new BxHttp(
                                            new TkApp()
                                        )
                                    )
                                )
                            )
//                            )
                        )

                    ), 30000
                )
            ),
            9999
        ).start(Exit.NEVER);
    }
}

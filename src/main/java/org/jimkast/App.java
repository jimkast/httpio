package org.jimkast;

import java.io.IOException;
import org.jimkast.http.bk.BkBasic;
import org.jimkast.http.bk.BkCloseStreams;
import org.jimkast.http.bk.BkRetry;
import org.jimkast.http.bk.BxBuffered;
import org.jimkast.http.bk.BxHttp;
import org.takes.http.BkParallel;
import org.takes.http.BkSafe;
import org.takes.http.Exit;
import org.takes.http.FtBasic;

public final class App {
    public static void main(String... args) throws IOException {
        new FtBasic(
            new BkParallel(
                new BkSafe(
                    new BkCloseStreams(
                        new BkRetry(
                            1000,
                            new BkBasic(
                                new BxBuffered(
                                    new BxHttp(
                                        new TkApp()
                                    )
                                )
                            )
                        )
                    )
                )
            ),
            9999
        ).start(Exit.NEVER);
    }
}

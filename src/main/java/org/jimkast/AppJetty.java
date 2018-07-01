package org.jimkast;

import java.io.IOException;
import org.jimkast.http.adapters.FtJetty;
import org.takes.http.Exit;

public final class AppJetty {
    public static void main(String... args) throws IOException {
        new FtJetty(
            9999,
            new TkApp()
        ).start(Exit.NEVER);
    }
}

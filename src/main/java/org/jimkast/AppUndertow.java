package org.jimkast;

import java.io.IOException;
import org.jimkast.http.adapters.FtUndertow;
import org.takes.http.Exit;

public final class AppUndertow {
    public static void main(String... args) throws IOException {
        new FtUndertow(
            9999,
            new TkApp()
        ).start(Exit.NEVER);
    }
}

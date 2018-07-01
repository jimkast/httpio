package org.jimkast;

import java.io.IOException;
import org.jimkast.http.adapters.FtSun;
import org.takes.http.Exit;

public final class AppSun {
    public static void main(String... args) throws IOException {
        new FtSun(
            9999,
            8,
            new TkApp()
        ).start(Exit.NEVER);
    }
}

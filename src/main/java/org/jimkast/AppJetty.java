package org.jimkast;

import java.io.IOException;
import java.nio.file.Paths;
import org.jimkast.http.route.ChkForUri;
import org.jimkast.http.route.ChkMethod;
import org.jimkast.http.route.FkExactMatch;
import org.jimkast.http.route.RtRegex;
import org.jimkast.http.route.RtSimple;
import org.jimkast.http.route.TkRoute;
import org.jimkast.http.rs.RsText;
import org.jimkast.http.tk.TkFiles;
import org.jimkast.http.tk.TkFixed;
import org.jimkast.http.adapters.FtJetty;
import org.jimkast.util.bool.And;
import org.jimkast.util.bool.ChkEqualsIgnoreCase;
import org.takes.http.Exit;

public final class AppJetty {
    public static void main(String... args) throws IOException {
        new FtJetty(
            9999,
            new TkRoute(
                new TkFixed(new RsText("Hello world!")),
                new RtSimple(
                    new And<>(
                        new ChkForUri(new ChkEqualsIgnoreCase("/ccc")),
                        new ChkMethod("GET")
                    ),
                    new TkFixed(new RsText("eee 235 346 rthfdghgf"))
                ),
                new FkExactMatch("/aaa", new TkFixed(new RsText("aaaaaaaaaaaaaaaaaaaaa"))),
                new RtRegex("/bbb", new TkFixed(new RsText("fgchcf 56y5"))),
                new RtRegex("/news/.*", new TkFiles(Paths.get("/data/images").toFile(), new RsText("File not found.")))
            )

        ).start(Exit.NEVER);
    }
}

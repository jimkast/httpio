package org.jimkast;

import java.io.IOException;
import java.nio.file.Paths;
import org.jimkast.http.bk.BkBasic;
import org.jimkast.http.bk.BkCloseStreams;
import org.jimkast.http.bk.BkWithTimeout;
import org.jimkast.http.bk.BxBuffered;
import org.jimkast.http.bk.BxHttp;
import org.jimkast.http.route.ChkForUri;
import org.jimkast.http.route.ChkMethod;
import org.jimkast.http.route.FkExactMatch;
import org.jimkast.http.route.RtRegex;
import org.jimkast.http.route.RtSimple;
import org.jimkast.http.route.TkRoute;
import org.jimkast.http.rs.RsText;
import org.jimkast.http.tk.TkFiles;
import org.jimkast.http.tk.TkFixed;
import org.jimkast.util.bool.And;
import org.jimkast.util.bool.ChkEqualsIgnoreCase;
import org.takes.http.BkSafe;
import org.takes.http.Exit;
import org.takes.http.FtBasic;

public final class App {
    public static void main(String... args) throws IOException {
        new FtBasic(
            new BkSafe(
                new BkCloseStreams(
                    new BkWithTimeout(
                        1000,
                        new BkBasic(
                            new BxBuffered(
                                new BxHttp(
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
                                )
                            )
                        )
                    )
                )
            ),
            8888
        ).start(Exit.NEVER);
    }
}

package org.jimkast;

import java.io.IOException;
import java.nio.file.Paths;
import org.jimkast.http.bk.BkBasic;
import org.jimkast.http.bk.BkCloseStreams;
import org.jimkast.http.bk.BxHttp;
import org.jimkast.http.body.RsWithBody;
import org.jimkast.http.route.ChkMethod;
import org.jimkast.http.route.ChkUri;
import org.jimkast.http.route.RouteRegex;
import org.jimkast.http.route.RouteSimple;
import org.jimkast.http.route.TkRoute;
import org.jimkast.http.tk.TkFiles;
import org.jimkast.http.tk.TkFixed;
import org.jimkast.util.bool.And;
import org.jimkast.util.bool.RegexMatchAll;
import org.takes.http.BkSafe;
import org.takes.http.Exit;
import org.takes.http.FtBasic;

public final class App {
    public static void main(String... args) throws IOException {
        new FtBasic(
            new BkSafe(
                new BkCloseStreams(
                    new BkBasic(
                        new BxHttp(
                            new TkRoute(
                                new TkFixed(new RsWithBody("Hello world!")),
                                new RouteSimple(
                                    new And<>(
                                        new ChkUri(new RegexMatchAll("/ccc")),
                                        new ChkMethod("GET")
                                    ),
                                    new TkFixed(new RsWithBody("eee 235 346 rthfdghgf"))
                                ),
                                new RouteRegex("/aaa", new TkFixed(new RsWithBody("aaaaaaaaaaaaaaaaaaaaa"))),
                                new RouteRegex("/bbb", new TkFixed(new RsWithBody("fgchcf 56y5"))),
                                new RouteRegex("/news/.*", new TkFiles(Paths.get("/data/images").toFile(), new RsWithBody("File not found.")))
                            )

                        )
                    )
                )
            ),
            8888
        ).start(Exit.NEVER);
    }
}

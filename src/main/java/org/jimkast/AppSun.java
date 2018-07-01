package org.jimkast;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.jimkast.bytes.BytesSource;
import org.jimkast.http.adapters.FtSun;
import org.jimkast.http.route.ChkForUri;
import org.jimkast.http.route.ChkMethod;
import org.jimkast.http.route.FkExactMatch;
import org.jimkast.http.route.RtRegex;
import org.jimkast.http.route.RtSimple;
import org.jimkast.http.route.TkRoute;
import org.jimkast.http.rs.RsBasic;
import org.jimkast.http.rs.RsText;
import org.jimkast.http.tk.TkFiles;
import org.jimkast.http.tk.TkFixed;
import org.jimkast.util.bool.And;
import org.jimkast.util.bool.ChkEqualsIgnoreCase;
import org.takes.http.Exit;

public final class AppSun {
    public static void main(String... args) throws IOException {
        new FtSun(
            9999,
            4,
            new TkRoute(
                new TkFixed(new RsText("Hello world!")),
                new RtSimple(
                    new And<>(
                        new ChkForUri(new ChkEqualsIgnoreCase("/ccc")),
                        new ChkMethod("GET")
                    ),
                    new TkFixed(new RsText("eee 235 346 rthfdghgf"))
                ),
                new FkExactMatch("/eee", new TkFixed(new RsBasic(
                    new BytesSource() {
                        @Override
                        public long print(OutputStream out) throws IOException {
                            byte[] bytes = "dfgdf g54tdghf 5y6 54yfcgh\n".getBytes();
                            for (int i = 0; i < 50; i++) {
                                out.write(bytes);
                            }
                            return 0;
                        }
                    }
                ))),
                new FkExactMatch("/aaa", new TkFixed(new RsText("aaaaaaaaaaaaaaaaaaaaa"))),
                new RtRegex("/bbb", new TkFixed(new RsText("fgchcf 56y5"))),
                new RtRegex("/news/.*", new TkFiles(Paths.get("/data/images").toFile(), new RsText("File not found.")))
            )
        ).start(Exit.NEVER);
    }
}

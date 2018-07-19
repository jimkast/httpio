package org.jimkast;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.jimkast.bool.And;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.http.HttpServerMapping;
import org.jimkast.http.route.ChkForMethod;
import org.jimkast.http.route.ChkForUri;
import org.jimkast.http.route.RtCaseMatch;
import org.jimkast.http.route.RtRegex;
import org.jimkast.http.route.RtSimple;
import org.jimkast.http.route.TkRoute;
import org.jimkast.http.rs.RsBasic;
import org.jimkast.http.rs.RsText;
import org.jimkast.http.tk.TkFiles;
import org.jimkast.http.tk.TkFixed;
import org.jimkast.io.BytesSource;

public final class TkApp extends HttpServerMapping.Envelope {
    public TkApp() {
        super(
            new TkRoute(
                new TkFixed(new RsText("404 not found...")),
                new RtSimple(
                    new And<>(
                        new ChkForUri(new ChkEqualsIgnoreCase("/ccc")),
                        new ChkForMethod("GET")
                    ),
                    new TkFixed(new RsText("eee 235 346 rthfdghgf"))
                ),
                new RtCaseMatch("/eee", new TkFixed(
                    new RsBasic(
                        out -> new BytesSource() {
                            @Override
                            public BytesSource print(OutputStream out) throws IOException {
                                byte[] bytes = "dfgdf g54tdghf 5y6 54yfcgh\n".getBytes();
                                for (int i = 0; i < 50; i++) {
                                    out.write(bytes);
                                }
                                return this;
                            }
                        }
                    )
                )),
                new RtCaseMatch("/qqq", in -> {
                    throw new RuntimeException("sdfds gdghf");
                }),
                new RtCaseMatch("/aaa", new TkFixed(new RsText("aaaaaaaaaaaaaaaaaaaaa"))),
                new RtRegex("/bbb", new TkFixed(new RsText("fgchcf 56y5"))),
                new RtRegex("/news/.*", new TkFiles(Paths.get("/data/images"), new RsText("File not found.")))
            )
        );
    }
}

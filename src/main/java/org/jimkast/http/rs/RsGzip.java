package org.jimkast.http.rs;

import java.util.zip.GZIPOutputStream;
import org.jimkast.http.Header;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeadersPairs;
import org.jimkast.io.bs.BsDecorated;

public final class RsGzip extends HttpOut.Envelope {
    public RsGzip(HttpOut origin) {
        super(
            new RsBasic(
                new HeadWithHeadersPairs(
                    new Header.Simple("Content-Encoding", "gzip")
                ),
                new BsDecorated(out -> new GZIPOutputStream(out, true), origin)
            )
        );
    }
}

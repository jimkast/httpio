package org.jimkast.http.rs;

import java.util.zip.GZIPOutputStream;
import org.jimkast.http.Prop;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeadersPairs;
import org.jimkast.io.bs.BsDecorated;

public final class RsGzip extends HttpOut.Envelope {
    public RsGzip(HttpOut origin) {
        super(
            new RsBasic(
                new HeadWithHeadersPairs(
                    new Prop.Simple("Content-Encoding", "gzip")
                ),
                new BsDecorated(out -> new GZIPOutputStream(out, true), origin)
            )
        );
    }
}

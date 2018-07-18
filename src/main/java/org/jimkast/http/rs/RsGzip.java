package org.jimkast.http.rs;

import java.util.zip.GZIPOutputStream;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeadersPairs;
import org.jimkast.io.bs.BsDecorated;
import org.jimkast.map.Prop;

public final class RsGzip extends HttpOut.Envelope {
    public RsGzip(HttpOut origin) {
        this(8192, origin);
    }

    public RsGzip(Number buf, HttpOut origin) {
        super(
            new RsBasic(
                new HeadWithHeadersPairs(
                    new Prop.Simple("Content-Encoding", "gzip")
                ),
                new BsDecorated(out -> new GZIPOutputStream(out, buf.intValue(), true), origin)
            )
        );
    }
}

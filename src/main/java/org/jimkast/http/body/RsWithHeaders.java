package org.jimkast.http.body;

import java.util.Arrays;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.http.head.MsgHead;

public final class RsWithHeaders extends HttpOut.Envelope {

    public RsWithHeaders(HttpOut origin, String... headers) {
        this(origin, Arrays.asList(headers));
    }

    public RsWithHeaders(HttpOut origin, Iterable<String> headers) {
        super(
            new RsBasic(
                new HeadWithHeaders(new MsgHead(origin), headers),
                origin
            )
        );
    }
}

package org.jimkast.http.tk;

import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.http.head.HeadWithStatus;
import org.jimkast.http.rs.RsBasic;
import org.jimkast.http.rs.RsEmpty;
import org.jimkast.map.Prop;

public final class RsRedirect extends HttpOut.Envelope {
    public RsRedirect(CharSequence location) {
        this(location, new RsEmpty());
    }

    public RsRedirect(CharSequence location, HttpOut origin) {
        this(303, location, origin);
    }

    public RsRedirect(Number code, CharSequence location, HttpOut origin) {
        super(
            new RsBasic(
                new HeadWithStatus(
                    code,
                    new HeadWithHeaders(
                        origin,
                        new Prop.Simple("Location", location)
                    )
                ),
                origin
            )
        );
    }
}

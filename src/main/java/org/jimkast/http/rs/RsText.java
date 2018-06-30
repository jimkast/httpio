package org.jimkast.http.rs;

import org.cactoos.io.InputOf;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.RsEmpty;
import org.jimkast.http.head.HeadWithContentType;

public final class RsText extends HttpOut.Envelope {
    public RsText(CharSequence text) {
        this(text, new RsEmpty());
    }

    public RsText(CharSequence text, HttpHead origin) {
        super(
            new RsBasic(
                new HeadWithContentType("text/plain", origin),
                new InputOf(text)
            )
        );
    }
}

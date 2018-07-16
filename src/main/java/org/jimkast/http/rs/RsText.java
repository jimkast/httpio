package org.jimkast.http.rs;

import org.cactoos.Input;
import org.cactoos.io.InputOf;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithContentType;

public final class RsText extends HttpOut.Envelope {
    public RsText(CharSequence text) {
        this(text, new RsEmpty());
    }

    public RsText(CharSequence text, HttpHead origin) {
        this(new InputOf(text), origin);
    }

    public RsText(Input text, HttpHead origin) {
        super(
            new RsInput(
                text,
                new HeadWithContentType("text/plain", origin)
            )
        );
    }
}

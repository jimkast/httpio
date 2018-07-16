package org.jimkast.http.rs;

import org.cactoos.Input;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.io.InputResettable;
import org.jimkast.io.InputWithCachedLength;
import org.jimkast.io.InputWithLength;
import org.jimkast.text.Concat;
import org.jimkast.text.TextEnvelope;

public final class RsInput extends HttpOut.Envelope {
    public RsInput(Input input) {
        this(new InputWithCachedLength(new InputResettable(input)));
    }

    public RsInput(Number length, Input input) {
        this(new InputWithLength.Known(length, input));
    }

    public RsInput(Input input, HttpHead origin) {
        this(new InputWithCachedLength(new InputResettable(input)), origin);
    }

    public RsInput(InputWithLength input) {
        this(input, new RsEmpty());
    }

    public RsInput(InputWithLength input, HttpHead origin) {
        super(
            new RsBasic(
                new HeadWithHeaders(
                    origin,
                    new Concat("Content-Length: ", new TextEnvelope(() -> String.valueOf(input.size())))
                ),
                input
            )
        );
    }
}

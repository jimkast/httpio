package org.jimkast.http.rs;

import org.cactoos.Input;
import org.jimkast.http.HttpHead;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.io.InputResettable;
import org.jimkast.io.InputWithLength;
import org.jimkast.io.InputWithUnknownLength;
import org.jimkast.text.Concat;
import org.jimkast.text.LazyText;

public final class RsWithUnknownBodyLength extends HttpOut.Envelope {
    public RsWithUnknownBodyLength(Input input, HttpHead origin) {
        this(new InputWithUnknownLength(new InputResettable(input)), origin);
    }

    public RsWithUnknownBodyLength(InputWithLength input, HttpHead origin) {
        super(
            new RsBasic(
                new HeadWithHeaders(
                    origin,
                    new Concat("Content-Length: ", new LazyText(() -> String.valueOf(input.size())))
                ),
                input
            )
        );
    }
}

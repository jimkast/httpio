package org.jimkast.http.rs;


import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.number.IntParsed;
import org.jimkast.number.NumberEnvelope;
import org.jimkast.text.TextEnvelope;

public final class RsStatus extends NumberEnvelope {
    public RsStatus(HttpHead rs) {
        super(
            new IntParsed(
                new TextEnvelope(
                    new ItemAt<>(
                        1,
                        new HttpHead.LineParts(rs)
                    )
                )
            )
        );
    }

}

package org.jimkast.http.rs;


import org.jimkast.http.HttpOut;
import org.jimkast.number.IntParsed;
import org.jimkast.number.NumberEnvelope;
import org.jimkast.text.TextEnvelope;
import org.jimkast.text.SubstringAfter;
import org.jimkast.text.SubstringBefore;

public final class RsStatus extends NumberEnvelope {
    public RsStatus(HttpOut rs) {
        super(
            new IntParsed(
                new SubstringBefore(
                    new SubstringAfter(
                        new TextEnvelope(rs::line),
                        " "
                    ),
                    " "
                )
            )
        );
    }

}

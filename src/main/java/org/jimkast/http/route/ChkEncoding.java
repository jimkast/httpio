package org.jimkast.http.route;

import org.jimkast.bool.PredicateEnvelope;
import org.jimkast.http.HttpHead;

public final class ChkEncoding extends PredicateEnvelope<HttpHead> {
    public ChkEncoding(CharSequence type) {
        super(
            new ChkForHeader("Accept-Encoding",
                new ChkForHeaderAnalyzedParts(
                    new ChkForHeaderPartValue(type)
                )
            )
        );
    }
}

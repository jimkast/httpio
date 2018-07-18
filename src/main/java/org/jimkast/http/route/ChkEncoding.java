package org.jimkast.http.route;

import java.util.Collection;
import org.jimkast.bool.PredicateEnvelope;
import org.jimkast.http.HttpHead;

public final class ChkEncoding extends PredicateEnvelope<HttpHead> {
    public ChkEncoding(Collection<String> types) {
        super(
            new ChkForHeader("Accept-Encoding",
                new ChkForHeaderAnalyzedParts(
                    part -> types.contains(part.value())
                )
            )
        );
    }
}

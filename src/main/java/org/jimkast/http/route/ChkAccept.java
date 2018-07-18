package org.jimkast.http.route;

import java.util.Arrays;
import java.util.Collection;
import org.jimkast.bool.PredicateEnvelope;
import org.jimkast.http.HttpHead;

public final class ChkAccept extends PredicateEnvelope<HttpHead> {
    public ChkAccept(String... types) {
        this(Arrays.asList(types));
    }

    public ChkAccept(Collection<String> types) {
        super(
            new ChkForHeader("Accept",
                new ChkForHeaderAnalyzedParts(
                    part -> types.contains(part.value())
                )
            )
        );
    }
}

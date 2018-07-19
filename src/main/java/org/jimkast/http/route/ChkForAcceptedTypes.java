package org.jimkast.http.route;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import org.jimkast.bool.PredicateEnvelope;
import org.jimkast.http.HttpHead;

public final class ChkForAcceptedTypes extends PredicateEnvelope<HttpHead> {
    public ChkForAcceptedTypes(String... types) {
        this(Arrays.asList(types));
    }

    public ChkForAcceptedTypes(Collection<String> types) {
        this(types::contains);
    }

    public ChkForAcceptedTypes(Predicate<String> check) {
        super(
            new ChkForHeader("Accept",
                new ChkForHeaderAnalyzedParts(
                    part -> check.test(part.value())
                )
            )
        );
    }
}

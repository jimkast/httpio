package org.jimkast.http.route;

import java.util.function.Predicate;
import org.jimkast.bool.ChkMatchAny;
import org.jimkast.http.HeaderPart;
import org.jimkast.http.parse.header.HeaderPartsAnalyzed;

public final class ChkForHeaderAnalyzedParts implements Predicate<String> {
    private final Predicate<HeaderPart> check;

    public ChkForHeaderAnalyzedParts(Predicate<HeaderPart> check) {
        this.check = check;
    }

    @Override
    public boolean test(String value) {
        return new ChkMatchAny<>(check).test(new HeaderPartsAnalyzed(value));
    }
}

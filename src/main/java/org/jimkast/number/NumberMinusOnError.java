package org.jimkast.number;

public final class NumberMinusOnError extends NumberEnvelope {
    public NumberMinusOnError(Number number) {
        super(new NumberParseSafe(-1, number));
    }
}

package org.jimkast.number;

public final class NumberMinusOnError extends NumberEnvelope {
    public NumberMinusOnError(Number number) {
        super(new IntParsedSafe(-1, number));
    }
}

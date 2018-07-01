package org.jimkast.number;

public class NumberEnvelope extends Number {
    private final Number number;

    public NumberEnvelope(Number number) {
        this.number = number;
    }

    @Override
    public final int intValue() {
        return number.intValue();
    }

    @Override
    public final long longValue() {
        return number.longValue();
    }

    @Override
    public final float floatValue() {
        return number.floatValue();
    }

    @Override
    public final double doubleValue() {
        return number.doubleValue();
    }

    @Override
    public final byte byteValue() {
        return number.byteValue();
    }

    @Override
    public final short shortValue() {
        return number.shortValue();
    }
}

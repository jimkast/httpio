package org.jimkast.number;

public class NumberEnvelope extends Number {
    private final Number origin;

    public NumberEnvelope(Number origin) {
        this.origin = origin;
    }

    @Override
    public final int intValue() {
        return origin.intValue();
    }

    @Override
    public final long longValue() {
        return origin.longValue();
    }

    @Override
    public final float floatValue() {
        return origin.floatValue();
    }

    @Override
    public final double doubleValue() {
        return origin.doubleValue();
    }

    @Override
    public final byte byteValue() {
        return origin.byteValue();
    }

    @Override
    public final short shortValue() {
        return origin.shortValue();
    }

    @Override
    public String toString() {
        return origin.toString();
    }

    @Override
    public int hashCode() {
        return origin.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return origin.equals(obj);
    }
}

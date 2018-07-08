package org.jimkast.number;

public abstract class IntEnvelope extends Number implements Int {
    @Override
    public long longValue() {
        return intValue();
    }

    @Override
    public float floatValue() {
        return intValue();
    }

    @Override
    public double doubleValue() {
        return intValue();
    }

    @Override
    public String toString() {
        return String.valueOf(intValue());
    }
}

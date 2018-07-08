package org.jimkast.number;

public abstract class DoubleEnvelope extends Number {
    @Override
    public long longValue() {
        return (int) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public String toString() {
        return String.valueOf(doubleValue());
    }
}

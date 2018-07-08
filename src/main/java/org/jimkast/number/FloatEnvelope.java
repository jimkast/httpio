package org.jimkast.number;

public abstract class FloatEnvelope extends Number {
    @Override
    public long longValue() {
        return (int) doubleValue();
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public String toString() {
        return String.valueOf(doubleValue());
    }

    @Override
    public double doubleValue() {
        return floatValue();
    }
}

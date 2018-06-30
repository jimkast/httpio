package org.jimkast.number;

public abstract class NumLong extends Number {
    @Override
    public int intValue() {
        return (int) longValue();
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
        return String.valueOf(longValue());
    }
}

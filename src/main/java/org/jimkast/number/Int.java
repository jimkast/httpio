package org.jimkast.number;

public abstract class Int extends Number implements IInt {
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

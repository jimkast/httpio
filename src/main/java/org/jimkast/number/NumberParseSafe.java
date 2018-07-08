package org.jimkast.number;

public final class NumberParseSafe extends Number {
    private final Number fallback;
    private final Number origin;

    public NumberParseSafe(Number fallback, Number origin) {
        this.fallback = fallback;
        this.origin = origin;
    }

    @Override
    public int intValue() {
        try {
            return origin.intValue();
        } catch (NumberFormatException e) {
            return fallback.intValue();
        }
    }

    @Override
    public long longValue() {
        try {
            return origin.longValue();
        } catch (NumberFormatException e) {
            return fallback.longValue();
        }
    }

    @Override
    public float floatValue() {
        try {
            return origin.floatValue();
        } catch (NumberFormatException e) {
            return fallback.floatValue();
        }
    }

    @Override
    public double doubleValue() {
        try {
            return origin.doubleValue();
        } catch (NumberFormatException e) {
            return fallback.doubleValue();
        }
    }

    @Override
    public byte byteValue() {
        try {
            return origin.byteValue();
        } catch (NumberFormatException e) {
            return fallback.byteValue();
        }
    }

    @Override
    public short shortValue() {
        try {
            return origin.shortValue();
        } catch (NumberFormatException e) {
            return fallback.shortValue();
        }
    }

    @Override
    public String toString() {
        try {
            return origin.toString();
        } catch (NumberFormatException e) {
            return fallback.toString();
        }
    }
}

package org.jimkast.number;

public final class DoubleParsed extends DoubleEnvelope {
    private final CharSequence text;

    public DoubleParsed(CharSequence text) {
        this.text = text;
    }

    @Override
    public double doubleValue() {
        return java.lang.Double.parseDouble(text.toString());
    }

    @Override
    public String toString() {
        return text.toString();
    }

}

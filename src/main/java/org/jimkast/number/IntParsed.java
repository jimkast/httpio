package org.jimkast.number;

public final class IntParsed extends IntEnvelope {
    private final CharSequence text;

    public IntParsed(CharSequence text) {
        this.text = text;
    }

    @Override
    public int intValue() {
        return Integer.parseInt(text.toString());
    }

    @Override
    public String toString() {
        return text.toString();
    }
}

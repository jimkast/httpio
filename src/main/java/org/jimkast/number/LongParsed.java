package org.jimkast.number;

public final class LongParsed extends LongEnvelope {
    private final CharSequence text;

    public LongParsed(CharSequence text) {
        this.text = text;
    }

    @Override
    public long longValue() {
        return Long.parseLong(text.toString());
    }

    @Override
    public String toString() {
        return text.toString();
    }
}

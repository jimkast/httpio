package org.jimkast.text;

public final class Trimmed extends TextEnvelope {
    public Trimmed(CharSequence str) {
        super(() -> str.toString().trim());
    }
}

package org.jimkast.text;

public final class TextBefore extends TextEnvelope {
    public TextBefore(CharSequence origin, CharSequence after) {
        this(origin, after, "");
    }

    public TextBefore(CharSequence origin, CharSequence after, CharSequence def) {
        super(() -> {
            String s = origin.toString();
            String a = after.toString();
            int pos = s.indexOf(a);
            return pos == -1 ? def.toString() : s.substring(0, pos);
        });
    }
}

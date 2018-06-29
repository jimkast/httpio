package org.jimkast.text;

public final class SubstringAfter extends LazyText {
    public SubstringAfter(CharSequence origin, CharSequence after) {
        this(origin, after, "");
    }

    public SubstringAfter(CharSequence origin, CharSequence after, CharSequence def) {
        super(() -> {
            String s = origin.toString();
            String a = after.toString();
            int pos = s.indexOf(a);
            return pos == -1 ? def.toString() : s.substring(pos + a.length());
        });
    }
}

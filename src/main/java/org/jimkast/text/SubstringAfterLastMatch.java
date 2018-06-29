package org.jimkast.text;

public final class SubstringAfterLastMatch extends LazyText {
    public SubstringAfterLastMatch(CharSequence origin, CharSequence after) {
        this(origin, after, "");
    }

    public SubstringAfterLastMatch(CharSequence origin, CharSequence after, CharSequence def) {
        super(() -> {
            String s = origin.toString();
            String a = after.toString();
            int pos = s.lastIndexOf(a);
            return pos == -1 ? def.toString() : s.substring(pos + a.length());
        });
    }
}

package org.jimkast.map.prop;

import java.util.Arrays;
import java.util.regex.Pattern;
import org.cactoos.iterable.StickyIterable;
import org.jimkast.map.Prop;

public final class PropSplit extends Prop.Envelope {
    public PropSplit(String split, CharSequence text) {
        this(Pattern.compile(split), text);
    }

    public PropSplit(Pattern split, CharSequence text) {
        super(new PropParts(new StickyIterable<>(() -> Arrays.asList(split.split(text.toString(), 2)).iterator())));
    }
}

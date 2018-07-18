package org.jimkast.map;

import java.util.regex.Pattern;
import org.cactoos.iterable.Mapped;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.text.stream.SplitText;

public final class PropsSplit extends IterableEnvelope<Prop> {
    public PropsSplit(String rgx1, String rgx2, CharSequence input) {
        this(Pattern.compile(rgx1), Pattern.compile(rgx2), input);
    }

    public PropsSplit(Pattern rgx1, Pattern rgx2, CharSequence input) {
        super(new Mapped<>(input1 -> new Prop.Split(rgx2, input1), new SplitText(rgx1, input)));
    }
}

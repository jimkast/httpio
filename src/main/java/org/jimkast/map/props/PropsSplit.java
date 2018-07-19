package org.jimkast.map.props;

import java.util.regex.Pattern;
import org.cactoos.iterable.Mapped;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.Prop;
import org.jimkast.map.prop.PropSplit;
import org.jimkast.text.TextInput;
import org.jimkast.text.stream.SplitText;
import org.jimkast.text.stream.TextInputOf;

public final class PropsSplit extends IterableEnvelope<Prop> {
    public PropsSplit(String rgx1, String rgx2, CharSequence input) {
        this(Pattern.compile(rgx1), Pattern.compile(rgx2), input);
    }

    public PropsSplit(String rgx1, String rgx2, TextInput input) {
        this(Pattern.compile(rgx1), Pattern.compile(rgx2), input);
    }

    public PropsSplit(Pattern rgx1, Pattern rgx2, CharSequence input) {
        this(rgx1, rgx2, new TextInputOf(input));
    }

    public PropsSplit(Pattern rgx1, Pattern rgx2, TextInput input) {
        super(new Mapped<>(input1 -> new PropSplit(rgx2, input1), new SplitText(rgx1, input)));
    }
}

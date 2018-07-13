package org.jimkast.bytes;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.jimkast.text.TextInput;

public final class SplitText implements Iterable<String> {
    private final Pattern regex;
    private final TextInput input;

    public SplitText(String regex, TextInput input) {
        this(Pattern.compile(regex), input);
    }

    public SplitText(Pattern regex, TextInput input) {
        this.regex = regex;
        this.input = input;
    }

    @Override
    public Iterator<String> iterator() {
        return new Scanner(new TextInput.Unchecked(input).stream()).useDelimiter(regex);
    }
}

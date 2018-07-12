package org.jimkast.bytes;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.jimkast.text.TextInput;

public final class SplitText implements Iterable<String> {
    private final Pattern regex;
    private final TextInput input;

    public SplitText(Pattern regex, TextInput input) {
        this.regex = regex;
        this.input = input;
    }

    @Override
    public Iterator<String> iterator() {
        Scanner scanner = new Scanner(new TextInput.Unchecked(input).stream()).useDelimiter(regex);
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }

            @Override
            public String next() {
                return scanner.next();
            }
        };
    }
}

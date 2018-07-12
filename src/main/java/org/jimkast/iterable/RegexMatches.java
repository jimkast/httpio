package org.jimkast.iterable;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.cactoos.Input;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

public final class RegexMatches implements Iterable<String> {
    private final Pattern ptn;
    private final UncheckedScalar<Reader> input;

    public RegexMatches(Pattern ptn, CharSequence text) {
        this(ptn, () -> new StringReader(text.toString()));
    }

    public RegexMatches(Pattern ptn, Input input) {
        this(ptn, input, StandardCharsets.UTF_8);
    }

    public RegexMatches(Pattern ptn, Input input, String charset) {
        this(ptn, input, Charset.forName(charset));
    }

    public RegexMatches(Pattern ptn, Input input, Charset charset) {
        this(ptn, () -> new InputStreamReader(input.stream(), charset));
    }

    public RegexMatches(Pattern ptn, Reader input) {
        this(ptn, () -> input);
    }

    public RegexMatches(Pattern ptn, Scalar<Reader> input) {
        this(ptn, new UncheckedScalar<>(input));
    }

    public RegexMatches(Pattern ptn, UncheckedScalar<Reader> input) {
        this.ptn = ptn;
        this.input = input;
    }

    @Override
    public java.util.Iterator<String> iterator() {
        return new Iterator(ptn, input.value());
    }


    public static final class Iterator implements java.util.Iterator<String> {
        private final Pattern ptn;
        private final Scanner input;

        public Iterator(Pattern ptn, Reader reader) {
            this(ptn, new Scanner(reader));
        }

        public Iterator(Pattern ptn, Scanner input) {
            this.ptn = ptn;
            this.input = input;
        }

        @Override
        public boolean hasNext() {
            return input.hasNext(ptn);
        }

        @Override
        public String next() {
            return input.next(ptn);
        }
    }
}

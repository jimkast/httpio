package org.jimkast.http;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jimkast.iterable.StringValues;
import org.jimkast.text.stream.SplitText;
import org.jimkast.text.stream.TextInputOf;

public interface HttpLine extends Iterable<String> {


    class Raw implements HttpLine {
        private static final Pattern WS = Pattern.compile("\\s+");
        private final Iterable<String> origin;

        public Raw(CharSequence origin) {
            this(new SplitText(WS, new TextInputOf(origin)));
        }

        public Raw(CharSequence part1, CharSequence part2, CharSequence part3) {
            this(new StringValues(part1, part2, part3));
        }

        public Raw(Iterable<String> origin) {
            this.origin = origin;
        }

        @Override
        public Iterator<String> iterator() {
            return origin.iterator();
        }
    }
}

package org.jimkast.v2.head;

import org.jimkast.v2.HttpHead;

public final class HeadWithLine implements HttpHead {
    private final CharSequence line;
    private final HttpHead origin;

    public HeadWithLine(CharSequence line) {
        this(line, new HeadRsEmpty());
    }

    public HeadWithLine(CharSequence line, HttpHead origin) {
        this.line = line;
        this.origin = origin;
    }

    @Override
    public String line() {
        return line.toString();
    }

    @Override
    public Iterable<String> headers() {
        return origin.headers();
    }
}

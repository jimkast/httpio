package org.jimkast.bytes;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.function.Predicate;
import org.jimkast.bool.Not;

public final class TrimmedRightReader extends FilterReader {
    private final Predicate<Character> check;

    public TrimmedRightReader(Reader in) {
        this(in, new Not<>(Character::isWhitespace));
    }

    public TrimmedRightReader(Reader origin, Predicate<Character> check) {
        super(origin);
        this.check = check;
    }

    @Override
    public int read() throws IOException {
        int read;
        do{
            read = super.read();
        } while(check.test((char) read));
        return read;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int ch = super.read(cbuf, off, len);

        if (ch == -1) {
            return -1;
        }

        int pos = off - 1;
        for (int readPos = off; readPos < off + ch; readPos++) {
            if (check.test((char) ch)) {
                continue;
            } else {
                pos++;
            }

            if (pos < readPos) {
                cbuf[pos] = cbuf[readPos];
            }
        }
        return pos - off + 1;
    }
}

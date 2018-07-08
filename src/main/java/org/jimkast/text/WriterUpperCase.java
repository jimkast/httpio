package org.jimkast.text;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public final class WriterUpperCase extends FilterWriter {

    public WriterUpperCase(Writer origin) {
        super(origin);
    }

    @Override
    public void write(int c) throws IOException {
        out.write(Character.toUpperCase(c));
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        char[] upper = new char[len - off];
        for (int i = off; i < len; i++) {
            upper[i] = Character.toUpperCase(cbuf[i]);
        }
        out.write(upper, 0, upper.length);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        write(cbuf, 0, cbuf.length);
    }
}

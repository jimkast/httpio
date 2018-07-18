package org.jimkast.net.bk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import org.jimkast.http.HttpHead;
import org.jimkast.io.BytesSource;
import org.jimkast.map.Prop;

public final class BsHttpHead implements BytesSource {
    private final HttpHead head;

    public BsHttpHead(HttpHead head) {
        this.head = head;
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        String eol = "\r\n";
        char delim = ':';
        char space = ' ';
        Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
        boolean nfirst = false;
        for (String s : head.line()) {
            if (nfirst) {
                writer.write(space);
            }
            nfirst = true;
            writer.write(s);
        }
        writer.write(eol);
        for (Prop h : head.headers()) {
            writer.write(h.name());
            writer.write(delim);
            writer.write(h.value());
            writer.write(eol);
        }
        writer.write(eol);
        writer.flush();
        return this;
    }
}

package org.jimkast.http.bk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import org.jimkast.bytes.BytesSource;
import org.jimkast.http.HttpHead;

public final class BsHttpHead implements BytesSource {
    private final HttpHead head;

    public BsHttpHead(HttpHead head) {
        this.head = head;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        String eol = "\r\n";
        Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
        writer.write(head.line());
        writer.write(eol);
        for (String s : head.headers()) {
            writer.write(s);
            writer.write(eol);
        }
        writer.write(eol);
        writer.flush();
        return 0;
    }
}

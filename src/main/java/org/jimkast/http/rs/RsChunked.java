package org.jimkast.http.rs;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.cactoos.iterable.Joined;
import org.jimkast.http.HttpLine;
import org.jimkast.http.HttpOut;
import org.jimkast.io.BytesSource;
import org.jimkast.map.Prop;
import org.jimkast.map.prop.PropSimple;
import sun.net.www.http.ChunkedOutputStream;

public final class RsChunked implements HttpOut {
    private final HttpOut out;

    public RsChunked(HttpOut out) {
        this.out = out;
    }

    @Override
    public HttpLine line() {
        return out.line();
    }

    @Override
    public Iterable<Prop> headers() {
        return new Joined<>(new PropSimple("Transfer-Encoding", "chucked"), out.headers());
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        return this.out.print(new ChunkedOutputStream(new PrintStream(out)));
    }
}

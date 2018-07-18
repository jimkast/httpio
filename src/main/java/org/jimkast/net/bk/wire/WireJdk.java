package org.jimkast.net.bk.wire;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.cactoos.list.StickyList;
import org.jimkast.http.Prop;
import org.jimkast.http.HttpIn;
import org.jimkast.http.HttpLine;
import org.jimkast.http.HttpOut;
import org.jimkast.http.rq.RqCachedHead;

public final class WireJdk implements HttpCodec {
    private final HttpURLConnection conn;

    public WireJdk(HttpURLConnection conn) {
        this.conn = conn;
    }

    @Override
    public HttpIn read() throws IOException {
        int status = conn.getResponseCode();
        return new RqCachedHead(
            new HttpIn() {
                @Override
                public HttpLine line() {
                    return new HttpLine.Raw(conn.getHeaderField(0));
                }

                @Override
                public Iterable<Prop> headers() {
                    List<Prop> headers = new ArrayList<>();
                    int total = conn.getHeaderFields().size();
                    for (int i = 1; i < total; i++) {
                        headers.add(new Prop.Simple(conn.getHeaderFieldKey(i), conn.getHeaderField(i)));
                    }
                    return headers;
                }

                @Override
                public InputStream stream() throws IOException {
                    return status >= 400 ? conn.getErrorStream() : conn.getInputStream();
                }
            }
        );
    }

    @Override
    public HttpCodec write(HttpOut out) throws IOException {
        List<String> line = new StickyList<>(out.line());
        HttpURLConnection conn = (HttpURLConnection) new URL(line.get(1)).openConnection();
        conn.setRequestMethod(line.get(0));
        for (Prop header : out.headers()) {
            conn.setRequestProperty(header.name(), header.value());
        }
        conn.setDoOutput(true);
        out.print(conn.getOutputStream());
        return this;
    }
}

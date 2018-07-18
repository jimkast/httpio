package org.jimkast.http.head;

import org.jimkast.http.HttpLine;
import org.jimkast.iterable.StringValues;

public final class RqLineBasic extends HttpLine.Raw {
    public RqLineBasic() {
        this("/");
    }

    public RqLineBasic(CharSequence uri) {
        this("GET", uri);
    }

    public RqLineBasic(CharSequence method, CharSequence uri) {
        this(method, uri, "HTTP/1.1");
    }

    public RqLineBasic(CharSequence method, CharSequence uri, CharSequence version) {
        super(new StringValues(method, uri, version));
    }
}

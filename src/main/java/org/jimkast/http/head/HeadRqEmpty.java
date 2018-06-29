package org.jimkast.http.head;

import java.util.Collections;
import org.jimkast.http.HttpHead;

public final class HeadRqEmpty implements HttpHead {
    @Override
    public String line() {
        return "GET / HTTP1/1";
    }

    @Override
    public Iterable<String> headers() {
        return Collections.emptyList();
    }
}

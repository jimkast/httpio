package org.jimkast.v2.head;

import java.util.Collections;
import org.jimkast.v2.HttpHead;

public final class HeadRsEmpty implements HttpHead {
    @Override
    public String line() {
        return "HTTP/1.1 200 OK";
    }

    @Override
    public Iterable<String> headers() {
        return Collections.emptyList();
    }
}

package org.jimkast.http.head;

import java.util.Iterator;
import org.jimkast.http.HttpHead;

public final class HeadLineParts implements Iterable<String> {
    private final HttpHead head;

    public HeadLineParts(HttpHead head) {
        this.head = head;
    }

    @Override
    public Iterator<String> iterator() {
        return head.line().iterator();
    }
}

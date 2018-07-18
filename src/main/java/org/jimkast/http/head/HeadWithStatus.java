package org.jimkast.http.head;

import org.jimkast.http.HttpHead;

public final class HeadWithStatus extends HttpHead.Envelope {
    public HeadWithStatus(Number code, HttpHead origin) {
       super(new HeadBasic(code, new HttpHead.Headers(origin)));
    }
}

package org.jimkast.http.route;

import org.jimkast.bool.PredicateEnvelope;
import org.jimkast.http.HttpHead;

public final class ChkAjax extends PredicateEnvelope<HttpHead> {
    public ChkAjax() {
        super(new ChkForHeader("X-Requested-With", "XMLHttpRequest"));
    }
}

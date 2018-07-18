package org.jimkast.http.parse;

import org.jimkast.bool.PredicateEnvelope;
import org.jimkast.http.HttpHead;
import org.jimkast.http.route.ChkHeaderWithValue;

public final class ChkAjax extends PredicateEnvelope<HttpHead> {
    public ChkAjax() {
        super(new ChkHeaderWithValue("X-Requested-With", "XMLHttpRequest"));
    }
}

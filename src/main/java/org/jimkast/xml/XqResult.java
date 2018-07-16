package org.jimkast.xml;

import org.jimkast.xml.saxon.XdmEnvelope;
import org.jimkast.xml.saxon.XdmSaxon;

public final class XqResult extends XdmEnvelope {
    public XqResult(XQuery xq) {
        this(xq, XdmSaxon.EMPTY);
    }

    public XqResult(XQuery xq, Xdm xdm) {
        super(() -> xq.evaluate(xdm.source()));
    }
}

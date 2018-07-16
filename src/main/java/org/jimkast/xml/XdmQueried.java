package org.jimkast.xml;


import org.jimkast.xml.saxon.XdmEnvelope;

public final class XdmQueried extends XdmEnvelope {
    public XdmQueried(Xdm origin, CharSequence q) {
        super(() -> origin.query(q));
    }
}

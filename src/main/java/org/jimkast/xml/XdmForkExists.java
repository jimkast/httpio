package org.jimkast.xml;

import org.jimkast.xml.saxon.XdmEnvelope;
import org.jimkast.xml.saxon.XdmSaxon;

public final class XdmForkExists extends XdmEnvelope {
    public XdmForkExists(Xdm origin) {
        this(origin, origin, XdmSaxon.EMPTY);
    }

    public XdmForkExists(Xdm origin, Xdm Else) {
        this(origin, origin, Else);
    }

    public XdmForkExists(Xdm origin, Xdm Then,  Xdm Else) {
        super(() -> origin.iterator().hasNext() ? Then : Else);
    }
}

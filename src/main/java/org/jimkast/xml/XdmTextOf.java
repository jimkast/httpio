package org.jimkast.xml;

import org.jimkast.text.TextEnvelope;

public final class XdmTextOf extends TextEnvelope {
    public XdmTextOf(Xdm xdm) {
        super(xdm::text);
    }
}

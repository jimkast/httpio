package org.jimkast.xml;

import javax.xml.transform.Source;
import org.jimkast.xml.saxon.XdmEnvelope;

public final class XslResult extends XdmEnvelope {
    public XslResult(Xsl xsl, Xdm xdm) {
        super(() -> xsl.apply(xdm.source()));
    }

    public XslResult(Xsl xsl, Source source) {
        super(() -> xsl.apply(source));
    }
}

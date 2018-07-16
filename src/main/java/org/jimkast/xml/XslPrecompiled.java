package org.jimkast.xml;

import java.io.IOException;
import java.io.UncheckedIOException;

public final class XslPrecompiled extends Xsl.Envelope {
    public XslPrecompiled(Xsl xsl) {
        super(xsl);
        try {
            xsl.apply(Xdm.EMPTY.source());
        } catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }
}

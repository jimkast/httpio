package org.jimkast.xml.saxon;

import java.io.IOException;
import java.util.Iterator;
import javax.xml.transform.Source;
import net.sf.saxon.s9api.XdmValue;
import org.cactoos.Scalar;
import org.jimkast.xml.Xdm;

public class XdmEnvelope implements SXdm {
    private final SXdm origin;

    public XdmEnvelope(Scalar<Xdm> origin) {
        this(new XdmSaxon(() -> SXdm.class.cast(origin.value()).xdm()));
    }

    public XdmEnvelope(Xdm origin) {
        this((SXdm) origin);
    }

    public XdmEnvelope(SXdm origin) {
        this.origin = origin;
    }

    @Override
    public final XdmValue xdm() {
        return origin.xdm();
    }

    @Override
    public final SXdm query(CharSequence xpath) throws IOException {
        return origin.query(xpath);
    }

    @Override
    public final String text() {
        return origin.text();
    }

    @Override
    public final String serialize() {
        return origin.serialize();
    }

    @Override
    public final Source source() {
        return origin.source();
    }

    @Override
    public final Iterator<Xdm> iterator() {
        return origin.iterator();
    }
}

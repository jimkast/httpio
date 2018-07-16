package org.jimkast.xml.saxon;

import org.jimkast.xml.XQuery;
import org.jimkast.xml.Xdm;
import org.jimkast.xml.XqResult;

public final class XdmWrapped extends XdmEnvelope {
    private static final XQuery XQ = new XqSaxon("declare variable $contents external; declare variable $name external; element {$name} {$contents}");

    public XdmWrapped(CharSequence name, Xdm origin) {
        super(new XqResult(XQ.with("contents", origin).with("name", new XdmSaxon(name))));
    }
}

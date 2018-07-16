package org.jimkast.xml.saxon;


import org.jimkast.xml.XQuery;
import org.jimkast.xml.Xdm;
import org.jimkast.xml.XqResult;

public final class XdmAppend extends XdmEnvelope {
    private static final XQuery XQ = new XqSaxon("declare variable $child external; element {name(.)} {./@*, ./*, $child}");

    public XdmAppend(Xdm origin, Xdm child) {
        super(new XqResult(XQ.with("child", child), origin));
    }
}

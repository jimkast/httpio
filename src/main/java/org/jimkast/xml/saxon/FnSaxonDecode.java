package org.jimkast.xml.saxon;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import net.sf.saxon.s9api.ExtensionFunction;
import net.sf.saxon.s9api.ItemType;
import net.sf.saxon.s9api.OccurrenceIndicator;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.SequenceType;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmValue;

public final class FnSaxonDecode implements ExtensionFunction {
    @Override
    public QName getName() {
        return new QName("http://www.w3.org/2005/xquery-local-functions", "decode-for-uri");
    }

    @Override
    public SequenceType getResultType() {
        return SequenceType.makeSequenceType(ItemType.ANY_ITEM, OccurrenceIndicator.ZERO_OR_MORE);
    }

    @Override
    public SequenceType[] getArgumentTypes() {
        return new SequenceType[]{
            SequenceType.makeSequenceType(ItemType.ANY_ITEM, OccurrenceIndicator.ZERO_OR_MORE)
        };
    }

    @Override
    public XdmValue call(XdmValue[] args) throws SaxonApiException {
        if (args.length == 0) return XdmValue.makeValue("");
        Iterator<XdmItem> iterator = args[0].iterator();
        try {
            return XdmValue.makeValue(iterator.hasNext() ? URLDecoder.decode(iterator.next().getStringValue(), "UTF-8") : "");
        } catch (UnsupportedEncodingException e) {
            throw new SaxonApiException(e);
        }
    }
}

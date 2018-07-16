package org.jimkast.xml.saxon;

import java.util.Iterator;
import net.sf.saxon.s9api.ExtensionFunction;
import net.sf.saxon.s9api.ItemType;
import net.sf.saxon.s9api.OccurrenceIndicator;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SequenceType;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmValue;
import org.jimkast.text.CleanedInvalidHtml;

public final class FnCleanInvalidHtml implements ExtensionFunction {
    @Override
    public QName getName() {
        return new QName("http://www.w3.org/2005/xquery-local-functions", "clean-invalid-html");
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
    public XdmValue call(XdmValue[] args) {
        if (args.length == 0) return XdmValue.makeValue("");
//        return args[0];
        Iterator<XdmItem> iterator = args[0].iterator();
        return XdmValue.makeValue(iterator.hasNext() ? new CleanedInvalidHtml(iterator.next().getStringValue()).toString() : "");
    }
}

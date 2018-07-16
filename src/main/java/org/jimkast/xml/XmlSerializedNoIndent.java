package org.jimkast.xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.jimkast.text.TextEnvelope;
import org.jimkast.xml.saxon.XslSaxon;

public final class XmlSerializedNoIndent extends TextEnvelope {
    private final Xdm xml;
    private static final Xsl XSL = new XslSaxon(
        new StringReader(
            "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                "    <xsl:output indent=\"no\"/>\n" +
                "    <xsl:strip-space elements=\"*\"/>\n" +
                "    \n" +
                "    <xsl:template match=\"@*|node()\">\n" +
                "        <xsl:copy>\n" +
                "            <xsl:apply-templates select=\"@*|node()\"/>\n" +
                "        </xsl:copy>\n" +
                "    </xsl:template>\n" +
                "</xsl:stylesheet>"
        )
    );

    public XmlSerializedNoIndent(Xdm xml) {
        super(() -> XSL.apply(xml.source(), new StringWriter()).toString());
        this.xml = xml;
    }

    public Writer print(Writer writer) throws IOException {
        return XSL.apply(xml.source(), writer);
    }
}

package org.jimkast.http.parse.header;

import java.util.regex.Pattern;
import org.jimkast.http.HttpHead;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.Prop;
import org.jimkast.map.PropsSplit;

public final class HeaderMetaProps extends IterableEnvelope<Prop> {
    private static final Pattern ptn1 = Pattern.compile("\\s*;\\s*");
    private static final Pattern ptn2 = Pattern.compile("\\s*=\\s*");
    private static final Pattern ptn3 = Pattern.compile("\\s*,\\s*");

    public HeaderMetaProps(HttpHead head, String name) {
        this(new HttpHeaderValue(head, name));
    }

    public HeaderMetaProps(CharSequence value) {
        super(new PropsSplit(ptn1, ptn2, value));
    }


    public static final class CommaSeparated extends IterableEnvelope<Prop> {
        public CommaSeparated(HttpHead head, String name) {
            this(new HttpHeaderValue(head, name));
        }

        public CommaSeparated(CharSequence value) {
            super(new PropsSplit(ptn3, ptn2, value));
        }
    }
}

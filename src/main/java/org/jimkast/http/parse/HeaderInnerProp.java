package org.jimkast.http.parse;

import org.jimkast.map.Prop;
import org.jimkast.text.Trimmed;

public final class HeaderInnerProp extends Prop.Envelope {
    public HeaderInnerProp(CharSequence part) {
        super(new Prop.Split("\\s*=\\s*", new Trimmed(part)));
    }
}

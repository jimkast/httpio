package org.jimkast.http.head;

import org.jimkast.map.Prop;
import org.jimkast.map.prop.PropSplit;
import org.jimkast.text.Trimmed;

public final class HeaderParsed extends Prop.Envelope {
    public HeaderParsed(CharSequence full) {
        super(new PropSplit("\\s*:\\s*", new Trimmed(full)));
    }
}

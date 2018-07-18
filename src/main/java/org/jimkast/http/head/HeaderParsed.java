package org.jimkast.http.head;

import org.jimkast.map.Prop;
import org.jimkast.text.Trimmed;

public final class HeaderParsed extends Prop.Envelope {
    public HeaderParsed(CharSequence full) {
        super(new Prop.Split("\\s*:\\s*", new Trimmed(full)));
    }
}

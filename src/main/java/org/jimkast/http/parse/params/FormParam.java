package org.jimkast.http.parse.params;

import org.jimkast.map.Prop;
import org.jimkast.map.prop.PropMappedBoth;
import org.jimkast.map.prop.PropSplit;

public final class FormParam extends Prop.Envelope {
    public FormParam(CharSequence text, CharSequence charset) {
        super(
            new PropMappedBoth(
                s -> new TextUrlDecoded(s, charset.toString()).toString(),
                new PropSplit("=", text)
            )
        );
    }
}

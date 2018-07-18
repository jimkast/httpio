package org.jimkast.http.parse;

import org.jimkast.text.SubstringAfter;
import org.jimkast.text.TextEnvelope;

public final class UriQueryString extends TextEnvelope {
    public UriQueryString(CharSequence uri) {
        super(new SubstringAfter(uri, "?"));
    }
}

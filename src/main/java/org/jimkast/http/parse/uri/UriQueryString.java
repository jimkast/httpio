package org.jimkast.http.parse.uri;

import org.jimkast.text.TextAfter;
import org.jimkast.text.TextEnvelope;

public final class UriQueryString extends TextEnvelope {
    public UriQueryString(CharSequence uri) {
        super(new TextAfter(uri, "?"));
    }
}

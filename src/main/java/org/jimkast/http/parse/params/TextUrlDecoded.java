package org.jimkast.http.parse.params;

import java.net.URLDecoder;
import org.jimkast.text.TextEnvelope;

public final class TextUrlDecoded extends TextEnvelope {
    public TextUrlDecoded(CharSequence str) {
        this(str, "UTF-8");
    }

    public TextUrlDecoded(CharSequence str, String charset) {
        super(() -> URLDecoder.decode(str.toString(), charset));
    }
}

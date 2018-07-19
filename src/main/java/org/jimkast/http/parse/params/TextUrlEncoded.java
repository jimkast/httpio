package org.jimkast.http.parse.params;

import java.net.URLEncoder;
import org.jimkast.text.TextEnvelope;

public final class TextUrlEncoded extends TextEnvelope {
    public TextUrlEncoded(CharSequence str) {
        this(str, "UTF-8");
    }

    public TextUrlEncoded(CharSequence str, String charset) {
        super(() -> URLEncoder.encode(str.toString(), charset));
    }
}

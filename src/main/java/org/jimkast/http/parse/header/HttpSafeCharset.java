package org.jimkast.http.parse.header;

import java.nio.charset.Charset;
import org.jimkast.text.TextEnvelope;

public final class HttpSafeCharset extends TextEnvelope {
    public HttpSafeCharset(CharSequence charset) {
        this(charset, "UTF-8");
    }

    public HttpSafeCharset(CharSequence charset, CharSequence def) {
        super(() -> {
            String enc = charset.toString();
            return Charset.isSupported(enc) ? enc : def.toString();
        });
    }
}

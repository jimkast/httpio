package org.jimkast.http.parse.header;

import java.util.function.Predicate;
import org.jimkast.bool.ChkEqualsIgnoreCase;
import org.jimkast.http.HttpHead;
import org.jimkast.map.PropsValue;
import org.jimkast.text.TextEnvelope;

public final class CookieValue extends TextEnvelope {
    public CookieValue(HttpHead head, String name) {
        this(head, new ChkEqualsIgnoreCase(name), "");
    }

    public CookieValue(HttpHead head, String name, CharSequence def) {
        this(head, new ChkEqualsIgnoreCase(name), def);
    }

    public CookieValue(HttpHead head, Predicate<String> check, CharSequence def) {
        super(new PropsValue(def, check, new RqCookies(head)));
    }
}
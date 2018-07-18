package org.jimkast.http.parse.uri;

import java.util.List;
import org.cactoos.scalar.ItemAt;
import org.jimkast.http.HttpHead;
import org.jimkast.iterable.SafeList;
import org.jimkast.text.TextEnvelope;

public final class UriPathValue extends TextEnvelope {
    public UriPathValue(HttpHead req, int pos) {
        this(new UriPath(req), pos);
    }

    public UriPathValue(CharSequence str, int pos) {
        this(new SafeList<>("", new UriComponents(str)), pos);
    }

    public UriPathValue(List<String> parts, int pos) {
        super(new ItemAt<>(pos, parts));
    }
}

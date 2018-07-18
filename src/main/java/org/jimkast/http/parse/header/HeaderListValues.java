package org.jimkast.http.parse.header;

import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.text.stream.SplitText;

public final class HeaderListValues extends IterableEnvelope<String> {
    public HeaderListValues(CharSequence header) {
        super(new SplitText("\\s*,\\s*", header));
    }
}

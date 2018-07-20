package org.jimkast.http.parse.header;

import org.cactoos.iterable.Mapped;
import org.jimkast.http.HeaderPart;
import org.jimkast.http.HttpHead;
import org.jimkast.iterable.IterableEnvelope;

public final class HeaderPartsAnalyzed extends IterableEnvelope<HeaderPart> {
    public HeaderPartsAnalyzed(HttpHead head, CharSequence header) {
        this(new HttpHeaderValue(head, header));
    }

    public HeaderPartsAnalyzed(CharSequence value) {
        super(
            new Mapped<>(
                HeaderPart.Parsed::new,
                new HeaderListValues(value)
            )
        );
    }
}

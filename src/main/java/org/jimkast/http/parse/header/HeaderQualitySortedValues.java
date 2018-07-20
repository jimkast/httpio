package org.jimkast.http.parse.header;

import java.util.Comparator;
import java.util.List;
import org.cactoos.iterable.Mapped;
import org.cactoos.iterable.Sorted;
import org.cactoos.list.ListOf;
import org.jimkast.http.HeaderPart;
import org.jimkast.http.HttpHead;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.props.PropsValue;
import org.jimkast.number.IntParsed;
import org.jimkast.number.NumberEnvelope;

public final class HeaderQualitySortedValues extends IterableEnvelope<String> {
    public HeaderQualitySortedValues(HttpHead head, CharSequence name) {
        this(new HttpHeaderValue(head, name));
    }

    public HeaderQualitySortedValues(CharSequence header) {
        this(new HeaderPartsAnalyzed(header));
    }

    public HeaderQualitySortedValues(Iterable<HeaderPart> parts) {
        this(new ListOf<>(parts));
    }

    public HeaderQualitySortedValues(List<HeaderPart> parts) {
        super(new Mapped<>(
            HeaderPart::value,
            new Sorted<>(Comparator.comparing(part -> new HdrPartQFactor(part).intValue()), parts)
        ));
    }

    public static final class HdrPartQFactor extends NumberEnvelope {
        public HdrPartQFactor(HeaderPart part) {
            super(
                new IntParsed(
                    new PropsValue(
                        "1",
                        "q",
                        () -> part.props().iterator()
                    )
                )
            );
        }
    }
}

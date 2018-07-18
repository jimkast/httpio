package org.jimkast.http.parse;

import org.cactoos.iterable.Mapped;
import org.jimkast.iterable.IterableEnvelope;
import org.jimkast.map.Prop;
import org.jimkast.text.stream.SplitText;

public final class HeaderInnerValues extends IterableEnvelope<Prop> {
    public HeaderInnerValues(CharSequence header) {
        super(
            new Mapped<>(
                single -> {
                    String[] pair = single.split("=", 2);
                    return new Prop.Simple(pair[0].trim(), pair.length < 2 ? "" : pair[1].trim());
                },
                new SplitText(";\\s*", header)
            )
        );
    }
}

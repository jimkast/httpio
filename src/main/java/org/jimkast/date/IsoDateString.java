package org.jimkast.date;

import java.util.Date;
import org.jimkast.text.TextEnvelope;

public final class IsoDateString extends TextEnvelope {
    public IsoDateString(Date date) {
        super(() -> date.toInstant().toString());
    }
}

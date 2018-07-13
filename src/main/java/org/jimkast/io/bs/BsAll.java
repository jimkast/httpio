package org.jimkast.io.bs;

import java.util.Arrays;
import org.jimkast.io.BytesSource;

public final class BsAll extends BytesSource.Envelope {
    public BsAll(BytesSource... all) {
        this(Arrays.asList(all));
    }

    public BsAll(Iterable<BytesSource> all) {
        super(new BsJoined(BytesSource.EMPTY, all));
    }
}

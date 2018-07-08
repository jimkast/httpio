package org.jimkast.io.bs;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jimkast.net.bk.BytesExchange;
import org.jimkast.io.BytesSource;

public final class BsBuffered implements BytesExchange {
    private final Number size;
    private final BytesExchange origin;

    public BsBuffered(BytesExchange origin) {
        this(8192, origin);
    }

    public BsBuffered(Number size, BytesExchange origin) {
        this.size = size;
        this.origin = origin;
    }

    @Override
    public BytesSource exchange(InputStream input) throws IOException {
        return origin.exchange(new BufferedInputStream(input, size.intValue()));
    }
}

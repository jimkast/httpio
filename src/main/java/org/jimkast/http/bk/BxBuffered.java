package org.jimkast.http.bk;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.jimkast.bytes.BytesSource;

public final class BxBuffered implements BytesExchange {
    private final Number size;
    private final BytesExchange origin;

    public BxBuffered(BytesExchange origin) {
        this(8192, origin);
    }

    public BxBuffered(Number size, BytesExchange origin) {
        this.size = size;
        this.origin = origin;
    }

    @Override
    public BytesSource exchange(InputStream input) throws IOException {
        return origin.exchange(new BufferedInputStream(input, size.intValue()));
    }
}

package org.jimkast.net.bk;

import java.io.IOException;
import java.io.InputStream;
import org.jimkast.io.bs.BsCloseOutput;
import org.jimkast.io.BytesSource;

public final class BxCloseOutput implements BytesExchange {
    private final BytesExchange origin;

    public BxCloseOutput(BytesExchange origin) {
        this.origin = origin;
    }

    @Override
    public BytesSource exchange(InputStream input) throws IOException {
        return new BsCloseOutput(origin.exchange(input));
    }
}

package org.jimkast.http.bk;

import java.io.IOException;
import java.io.InputStream;
import org.jimkast.bytes.BytesSource;

public final class BxCloseInput implements BytesExchange {
    private final BytesExchange origin;

    public BxCloseInput(BytesExchange origin) {
        this.origin = origin;
    }

    @Override
    public BytesSource exchange(InputStream input) throws IOException {
        try (InputStream in = input) {
            return origin.exchange(in);
        }
    }
}

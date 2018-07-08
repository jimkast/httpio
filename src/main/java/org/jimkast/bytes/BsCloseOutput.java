package org.jimkast.bytes;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.io.BytesSource;

public final class BsCloseOutput implements BytesSource {
    private final BytesSource origin;

    public BsCloseOutput(BytesSource origin) {
        this.origin = origin;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        try (OutputStream output = out) {
            return origin.print(output);
        }
    }
}

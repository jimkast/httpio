package org.jimkast.http.rs;

import java.io.IOException;
import java.io.UncheckedIOException;
import org.jimkast.number.Int;
import org.takes.Response;

public final class RsStatus extends Int {
    private final Response rs;

    public RsStatus(Response rs) {
        this.rs = rs;
    }

    @Override
    public int intValue() {
        try {
            return Integer.parseInt(rs.head().iterator().next().split("\\s+", 3)[1]);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

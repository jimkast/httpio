package org.jimkast.bytes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public final class BsAll implements BytesSource {
    private final Iterable<BytesSource> all;

    public BsAll(BytesSource... all) {
        this(Arrays.asList(all));
    }

    public BsAll(Iterable<BytesSource> all) {
        this.all = all;
    }

    @Override
    public long print(OutputStream out) throws IOException {
        long count = 0;
        for (BytesSource source : all) {
            count += source.print(out);
        }
        return count;
    }
}

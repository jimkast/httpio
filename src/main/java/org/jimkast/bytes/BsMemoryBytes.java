package org.jimkast.bytes;

import java.io.ByteArrayOutputStream;
import org.cactoos.Bytes;
import org.jimkast.io.BytesSource;

public final class BsMemoryBytes implements Bytes {
    private final BytesSource source;

    public BsMemoryBytes(BytesSource source) {
        this.source = source;
    }

    @Override
    public byte[] asBytes() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        source.print(baos);
        return baos.toByteArray();
    }
}

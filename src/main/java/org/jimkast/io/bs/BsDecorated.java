package org.jimkast.io.bs;

import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.io.BytesSource;
import org.jimkast.io.IoFunc;

public final class BsDecorated implements BytesSource {
    private final IoFunc<OutputStream, OutputStream> decorator;
    private final BytesSource origin;

    public BsDecorated(IoFunc<OutputStream, OutputStream> decorator, BytesSource origin) {
        this.decorator = decorator;
        this.origin = origin;
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        return origin.print(decorator.apply(out));
    }
}

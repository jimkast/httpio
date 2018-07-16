package org.jimkast.io.bs;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.cactoos.io.InputOf;
import org.jimkast.io.BytesSource;

public final class BsJoined implements BytesSource {
    private final BytesSource delim;
    private final Iterable<BytesSource> all;

    public BsJoined(CharSequence str, BytesSource... all) {
        this(str, Arrays.asList(all));
    }

    public BsJoined(CharSequence str, Iterable<BytesSource> all) {
        this(new BsInput(new InputOf(str)), all);
    }

    public BsJoined(CharSequence str, Charset charset, BytesSource... all) {
        this(str, charset, Arrays.asList(all));
    }

    public BsJoined(CharSequence str, Charset charset, Iterable<BytesSource> all) {
        this(new BsInput(new InputOf(str, charset)), all);
    }

    public BsJoined(BytesSource delim, Iterable<BytesSource> all) {
        this.delim = delim;
        this.all = all;
    }

    @Override
    public BytesSource print(OutputStream out) throws IOException {
        boolean nfirst = true;
        for (BytesSource source : all) {
            if (nfirst) {
                delim.print(out);
                nfirst = false;
            }
            source.print(out);
        }
        return this;
    }
}

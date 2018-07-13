package org.jimkast.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UncheckedIOException;
import java.util.Enumeration;
import java.util.Iterator;
import org.cactoos.Input;

public class InputAll implements Input {
    private final Iterable<Input> all;

    public InputAll(Iterable<Input> all) {
        this.all = all;
    }

    @Override
    public InputStream stream() throws Exception {
        Iterator<Input> iter = all.iterator();
        return new SequenceInputStream(new Enumeration<InputStream>() {
            @Override
            public boolean hasMoreElements() {
                return iter.hasNext();
            }

            @Override
            public InputStream nextElement() {
                try {
                    return iter.next().stream();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}

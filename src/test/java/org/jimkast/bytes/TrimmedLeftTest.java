package org.jimkast.bytes;

import java.io.IOException;
import java.io.StringReader;
import org.cactoos.io.DeadOutputStream;
import org.cactoos.io.InputOf;
import org.cactoos.text.TextOf;
import org.cactoos.text.TrimmedLeftText;
import org.jimkast.io.bs.InputAsByteSource;
import org.junit.Test;
import org.xnio.streams.ReaderInputStream;

public class TrimmedLeftTest {

    @Test
    public void stream() throws IOException {
        new InputAsByteSource(
            new InputOf(
                new ReaderInputStream(
                    new TrimmedLeft(() -> new StringReader("  \n      sdfg dgh 45y rfh  ")).stream()
                )
            )
        ).print(new DeadOutputStream());
    }

    @Test
    public void stream22() throws IOException {
        for (int i = 0; i < 100000; i++) {
            stream();
        }
    }

    @Test
    public void stream2() throws Exception {
        new InputAsByteSource(
            new InputOf(new TrimmedLeftText(new TextOf("  \n      sdfg dgh 45y rfh  "))
            )
        ).print(new DeadOutputStream());
    }

    @Test
    public void stream22222() throws Exception {
        for (int i = 0; i < 100000; i++) {
            stream2();
        }
    }
}
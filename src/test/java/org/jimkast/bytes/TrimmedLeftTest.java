package org.jimkast.bytes;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import org.cactoos.io.DeadOutputStream;
import org.cactoos.io.InputOf;
import org.cactoos.text.TextOf;
import org.cactoos.text.TrimmedLeftText;
import org.jimkast.io.bs.InputAsByteSource;
import org.jimkast.text.TextInput;
import org.junit.Test;
import org.xnio.streams.ReaderInputStream;

public class TrimmedLeftTest {

    @Test
    public void split() throws IOException {
        TextInput in = () -> new StringReader("  \n      sdfg dgha 45y rfh  ");
        for (String s : new SplitText("\\s+", in)) {
            System.out.println("part: " + s);
        }
    }


    @Test
    public void stream() throws IOException {
        TextInput in = () -> new StringReader("  \n      sdfg dgha 45y rfh  ");
        new InputAsByteSource(
            new InputOf(
                new ReaderInputStream(
                    new TextLimited(
                        5,
                        new TextSkipped(
                            3,
                            new TextTrimmedLeft(
                                in
                            )
                        )
                    ).stream(),
                    StandardCharsets.UTF_8.newEncoder(),
                    16
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
            new InputOf(new TrimmedLeftText(new TextOf("  \n      sdfg dgha 45y rfh  ")).asString().substring(3, 5)
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
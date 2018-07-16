package org.jimkast.bytes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.cactoos.io.DeadOutputStream;
import org.cactoos.io.InputOf;
import org.cactoos.text.TextOf;
import org.cactoos.text.TrimmedLeftText;
import org.jimkast.io.bs.BsInput;
import org.jimkast.text.stream.TextInputOf;
import org.jimkast.text.stream.SplitText;
import org.jimkast.text.stream.TextLimited;
import org.jimkast.text.stream.TextSkipped;
import org.jimkast.text.stream.TextTrimmedLeft;
import org.junit.Test;
import org.xnio.streams.ReaderInputStream;

public class TrimmedLeftTest {

    @Test
    public void split() throws IOException {
        for (String s : new SplitText("\\s+", new TextInputOf("  \n      sdfg dgha 45y rfh  "))) {
            System.out.println("part: " + s);
        }
    }


    @Test
    public void stream() throws IOException {
        new BsInput(
            new InputOf(
                new ReaderInputStream(
                    new TextLimited(
                        5,
                        new TextSkipped(
                            3,
                            new TextTrimmedLeft(
                                new TextInputOf("  \n      sdfg dgha 45y rfh  ")
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
        new BsInput(
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
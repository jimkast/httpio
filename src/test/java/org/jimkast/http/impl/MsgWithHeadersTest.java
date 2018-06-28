package org.jimkast.http.impl;

import java.nio.file.Paths;
import org.cactoos.io.InputOf;
import org.cactoos.io.LengthOf;
import org.cactoos.io.OutputTo;
import org.cactoos.io.TeeInput;
import org.junit.Test;
import sun.net.www.http.ChunkedOutputStream;

public class MsgWithHeadersTest {

    @Test
    public void line() throws Exception {
        new LengthOf(
            new TeeInput(
                new InputOf(Paths.get("/data/images/news/aaaa.html")),
                new OutputTo(
                    new ChunkedOutputStream(
                        System.out,
                        256
                    )
                )
            )
        ).value();

    }
}
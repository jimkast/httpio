package org.jimkast.http.impl;

import java.io.File;
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
                new InputOf(new File("C:\\Users\\jimkast\\Desktop\\booking-sample.xml")),
                new OutputTo(
                    new ChunkedOutputStream(
                        System.out,
                        512
                    )
                )
            )
        ).value();

    }
}
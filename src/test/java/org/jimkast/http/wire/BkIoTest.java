package org.jimkast.http.wire;

import java.io.IOException;
import org.jimkast.TkApp;
import org.jimkast.http.bk.BxHttp;
import org.junit.Test;

public class BkIoTest {

    @Test
    public void trigger() throws IOException {
        new BkNio(8081)
            .trigger(
                new SessionRsRq(
                    new BxHttp(
                        new TkApp()
                    )
                )
            );
    }
}
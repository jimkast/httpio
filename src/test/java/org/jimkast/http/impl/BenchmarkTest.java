package org.jimkast.http.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.cactoos.io.InputOf;
import org.jimkast.io.bs.InputAsByteSource;
import org.junit.Test;

public final class BenchmarkTest {
    @Test
    public void jetty() throws Exception {
        Callable<String> c = () -> {
            new InputAsByteSource(new InputOf(new URL("http://localhost:9999/ccc"))).print(System.out);
            System.out.println("");
            return "123";
        };
        c.call();

        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(c);
        }
        ExecutorService svc = Executors.newFixedThreadPool(20);
        svc.invokeAll(list);
    }
}

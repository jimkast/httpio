package org.jimkast.http.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.cactoos.text.TextOf;
import org.junit.Test;

public final class BenchmarkTest {
    @Test
    public void jetty() throws Exception {
        Callable<String> c = () -> {
            String res = new TextOf(new URL("http://localhost:9999/ccc")).asString();
            System.out.println(res);
            return res;
        };

        List<Callable<String>> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(c);
        }
        ExecutorService svc = Executors.newFixedThreadPool(20);
        svc.invokeAll(list);
    }
}

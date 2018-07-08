package org.jimkast.http.wire;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class SessionParallel implements Session {
    private final Executor svc;
    private final Session origin;

    public SessionParallel(int size, Session origin) {
        this(Executors.newFixedThreadPool(size), origin);
    }

    public SessionParallel(Executor svc, Session origin) {
        this.svc = svc;
        this.origin = origin;
    }

    @Override
    public void accept(Connection channel) {
        svc.execute(() -> {
            try {
                origin.accept(channel);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }
}

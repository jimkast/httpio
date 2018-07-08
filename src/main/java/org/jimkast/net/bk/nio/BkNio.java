package org.jimkast.net.bk.nio;

import org.jimkast.http.HttpServerMapping;

public final class BkNio implements Runnable {
    private final HttpServerMapping mapping;

    public BkNio(HttpServerMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public void run() {

    }
}

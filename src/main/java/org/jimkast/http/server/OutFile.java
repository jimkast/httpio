package org.jimkast.http.server;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.jimkast.bytes.BytesSource;

public final class OutFile implements BytesSource {
    private final File file;

    public OutFile(File file) {
        this.file = file;
    }



    @Override
    public BytesSource print(OutputStream out) throws IOException {
        return null;
    }
}

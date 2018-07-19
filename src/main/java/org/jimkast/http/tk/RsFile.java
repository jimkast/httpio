package org.jimkast.http.tk;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import org.cactoos.Scalar;
import org.jimkast.http.HttpOut;
import org.jimkast.http.head.HeadWithHeaders;
import org.jimkast.http.rs.RsBasic;
import org.jimkast.io.BytesSource;
import org.jimkast.io.bs.BsFile;
import org.jimkast.map.prop.PropSimple;
import org.jimkast.number.LongEnvelope;
import org.jimkast.text.StringValue;
import org.jimkast.text.TextEnvelope;

public final class RsFile extends HttpOut.Envelope {
    public RsFile(File file) {
        this(file.toPath());
    }

    public RsFile(Path file) {
        this(
            new LongEnvelope() {
                @Override
                public long longValue() {
                    try {
                        return Files.size(file);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }
            },
            () -> Files.getLastModifiedTime(file).toInstant(),
            new BsFile(file)
        );
    }

    public RsFile(Number length, Scalar<Instant> date, BytesSource body) {
        super(
            new RsBasic(
                new HeadWithHeaders(
                    new PropSimple("Content-Length", new StringValue(length)),
                    new PropSimple("Last-Modified", new TextEnvelope(() -> date.value().toString()))
                ),
                body
            )
        );
    }

}

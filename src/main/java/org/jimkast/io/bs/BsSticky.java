package org.jimkast.io.bs;

import org.cactoos.io.InputOf;
import org.jimkast.io.BytesSource;
import org.jimkast.io.BytesSticky;

public final class BsSticky extends BytesSource.Envelope {
    public BsSticky(BytesSource origin) {
        super(
            new BsInput(
                new InputOf(
                    new BytesSticky(
                        new BsMemoryBytes(
                            origin
                        )
                    )
                )
            )
        );
    }
}

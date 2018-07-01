package org.jimkast.io;

import java.io.InputStream;
import org.cactoos.Input;

public interface InputWithLength extends Input {
    long size();

    @Override
    InputStream stream() throws Exception;
}

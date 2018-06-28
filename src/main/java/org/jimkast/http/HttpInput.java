package org.jimkast.http;

import java.io.InputStream;
import org.cactoos.Input;
import org.cactoos.Text;

public interface HttpInput extends Input {
    Text line();

    Iterable<Header> headers();

    @Override
    InputStream stream() throws Exception;
}

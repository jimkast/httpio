package org.jimkast.http;

import org.cactoos.Text;
import org.jimkast.bytes.BytesSource;

public interface HttpMessage {
    Text line();

    Iterable<Header> headers();

    BytesSource body();
}

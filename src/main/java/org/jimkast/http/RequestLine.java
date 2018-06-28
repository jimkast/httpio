package org.jimkast.http;


import org.cactoos.Text;

public interface RequestLine extends Text {
    String method();

    String uri();

    String version();
}

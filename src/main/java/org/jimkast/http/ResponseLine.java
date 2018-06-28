package org.jimkast.http;


import org.cactoos.Text;

public interface ResponseLine extends Text {
    int status();

    String version();

    String reason();
}

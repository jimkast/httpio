package org.jimkast.http;

public interface HttpServer {
    HttpOutput respond(HttpInput request);
}

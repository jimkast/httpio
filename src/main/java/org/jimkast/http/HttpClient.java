package org.jimkast.http;

public interface HttpClient {
    HttpInput send(HttpOutput request);
}

package org.jimkast.http;

public interface HttpServerMapping {
    HttpOut exchange(HttpIn in);
}

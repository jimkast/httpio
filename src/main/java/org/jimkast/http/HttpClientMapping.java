package org.jimkast.http;

public interface HttpClientMapping {
    HttpIn exchange(HttpOut request);
}

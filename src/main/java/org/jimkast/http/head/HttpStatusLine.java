package org.jimkast.http.head;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.jimkast.http.HttpLine;
import org.jimkast.iterable.StringValues;
import org.jimkast.map.Mapping;
import org.jimkast.text.TextEnvelope;

public final class HttpStatusLine extends HttpLine.Raw {
    public HttpStatusLine(Number code) {
        this(code, new HttpDefaultReason(code));
    }

    public HttpStatusLine(Number code, CharSequence reason) {
        this("HTTP/1.1", code, reason);
    }

    public HttpStatusLine(CharSequence version, Number code, CharSequence reason) {
        super(new StringValues(version, new TextEnvelope(code::toString), reason));
    }


    public static final class HttpDefaultReason extends TextEnvelope {
        private static final Mapping<Integer, String> MAPPING = make();

        public HttpDefaultReason(Number code) {
            this(code, MAPPING);
        }

        public HttpDefaultReason(Number code, Mapping<Integer, String> mapping) {
            super(() -> mapping.map(code.intValue()));
        }

        private static Mapping<Integer, String> make() {
            final Map<Integer, String> map = new HashMap<>(0);
            map.put(HttpURLConnection.HTTP_OK, "OK");
            map.put(HttpURLConnection.HTTP_NO_CONTENT, "No Content");
            map.put(HttpURLConnection.HTTP_CREATED, "Created");
            map.put(HttpURLConnection.HTTP_ACCEPTED, "Accepted");
            map.put(HttpURLConnection.HTTP_MOVED_PERM, "Moved Permanently");
            map.put(HttpURLConnection.HTTP_MOVED_TEMP, "Moved Temporarily");
            map.put(HttpURLConnection.HTTP_SEE_OTHER, "See Other");
            map.put(HttpURLConnection.HTTP_NOT_MODIFIED, "Not Modified");
            map.put(HttpURLConnection.HTTP_USE_PROXY, "Use Proxy");
            map.put(HttpURLConnection.HTTP_BAD_REQUEST, "Bad Request");
            map.put(HttpURLConnection.HTTP_UNAUTHORIZED, "Unauthorized");
            map.put(HttpURLConnection.HTTP_PAYMENT_REQUIRED, "Payment Required");
            map.put(HttpURLConnection.HTTP_FORBIDDEN, "Forbidden");
            map.put(HttpURLConnection.HTTP_NOT_FOUND, "Not Found");
            map.put(HttpURLConnection.HTTP_BAD_METHOD, "Bad Method");
            map.put(HttpURLConnection.HTTP_NOT_ACCEPTABLE, "Not Acceptable");
            map.put(HttpURLConnection.HTTP_CLIENT_TIMEOUT, "Client Timeout");
            map.put(HttpURLConnection.HTTP_GONE, "Gone");
            map.put(HttpURLConnection.HTTP_LENGTH_REQUIRED, "Length Required");
            map.put(HttpURLConnection.HTTP_PRECON_FAILED, "Precon Failed");
            map.put(HttpURLConnection.HTTP_ENTITY_TOO_LARGE, "Entity Too Large");
            map.put(HttpURLConnection.HTTP_REQ_TOO_LONG, "Request Too Long");
            map.put(HttpURLConnection.HTTP_UNSUPPORTED_TYPE, "Unsupported Type");
            map.put(HttpURLConnection.HTTP_INTERNAL_ERROR, "Internal Error");
            map.put(HttpURLConnection.HTTP_BAD_GATEWAY, "Bad Gateway");
            map.put(HttpURLConnection.HTTP_NOT_IMPLEMENTED, "Not Implemented");
            return new Mapping.Simple<>("Unknown", map);
        }
    }
}

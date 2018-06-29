package org.jimkast.http.head;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.jimkast.text.LazyText;
import org.jimkast.util.Mapping;
import org.jimkast.http.HttpHead;

public final class HeadWithStatus extends HttpHead.Envelope {
    public HeadWithStatus(Number status) {
        this(status, new HttpDefaultReason(status));
    }

    public HeadWithStatus(Number status, CharSequence msg) {
        this(status, msg, new HeadRsEmpty());
    }

    public HeadWithStatus(Number status, HttpHead origin) {
        this(status, new HttpDefaultReason(status), origin);
    }

    public HeadWithStatus(Number status, CharSequence msg, HttpHead origin) {
        super(
            new HeadWithLine(
                new LazyText(() -> "HTTP1/1 " + status + " " + msg),
                origin
            )
        );
    }


    public static final class HttpDefaultReason extends LazyText {
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

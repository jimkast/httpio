package org.jimkast.http.bk.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HttpHandler implements Handler {
    protected abstract Result serve(String uri);

    /**
     * Class Result represents the result which has to be sent back
     * to the client. Implementors have to implement addHeaders and writeBody.
     */
    public static abstract class Result {
        private final String resultCode;
        private final StringBuffer headerBuffer = new StringBuffer();
        public Result(String resultCode) {
            this.resultCode = resultCode;
        }
        public String getResultCode() {
            return resultCode;
        }
        public String getHeaders() {
            return headerBuffer.toString();
        }

        void addResponseHeader(String header, String value) {
            headerBuffer
                .append(header)
                .append(": ")
                .append(value)
                .append("\r\n");
        }

        protected abstract void addHeaders();
        protected abstract void writeBody(OutputStream os) throws IOException;
    }

    private void fail(Writer writer, String code) throws IOException {
        writer.append("HTTP/1.0 ")
            .append(code)
            .append("\r\n");
    }

    private final static Pattern HeaderLine = Pattern.compile("([^:]*):\\s*(.*)");
    private Map<String, String> readHeaders(BufferedReader reader) throws IOException {
        Map<String, String> headers = new LinkedHashMap<String, String>();

        int length = 0;
        do {
            String line = reader.readLine();
            length = line.length();
            if (length > 0) {
                Matcher matcher = HeaderLine.matcher(line);
                if (matcher.matches())
                    headers.put(matcher.group(1), matcher.group(2).toLowerCase());
                else
                    ;//log("Skipping invalid header: '%s'", line);
            }
        } while (length > 0) ;

        return headers;
    }
    private boolean shouldKeepAlive(Map<String, String> headers, String version) {
        boolean hasConnectionKeepAlive =
            headers.containsKey("Connection") &&
                headers.get("Connection").contains("keep-alive");
        boolean hasConnectionClose =
            headers.containsKey("Connection") &&
                headers.get("Connection").contains("close");

        // Keep-Alive in HTTP/1.0: Not specified but implementations use
        // header "Connection: Keep-Alive" to flag a persistent connection.
        // The receiver has to acknowledge the persistent connection with a response header
        // "Connection: Keep-Alive" and possibly additional information with the header
        // "Keep-Alive: [...]"
        // see http://ftp.ics.uci.edu/pub/ietf/http/hypermail/1995q4/0063.html
        // and RFC 2068 ("19.7.1 Compatibility with HTTP/1.0 Persistent Connections")
        //
        // In HTTP/1.1 (RFC 2616): A connection is considered persistent
        // by default. The sender can flag a connection close with the request header
        // "Connection: close"
        return
            ("1.0".equals(version) &&
                hasConnectionKeepAlive
            ) ||
                ("1.1".equals(version) &&
                    !hasConnectionClose);
    }

    @Override
    public boolean handleConnection(Socket client) throws IOException {
        client.setSoTimeout(Settings.firstReadTimeout);

        return waitAndServeRequest(client);
    }
    final static Pattern GETHEADRequest = Pattern.compile("(GET|HEAD) ([^ ]+) HTTP/(\\d\\.\\d)");
    private boolean waitAndServeRequest(Socket client) throws IOException {
        final OutputStream os = client.getOutputStream();
        final Writer writer = new OutputStreamWriter(os);

        final InputStream is = client.getInputStream();
        // FIXME: to read request bodies we would have to make sure to use correct encoding here
        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        // Request processing
        try {
            String requestLine = reader.readLine();

            // Headers have to be send continuously without to much pauses in between
            client.setSoTimeout(Settings.headerTimeout);
            Map<String, String> headers = readHeaders(reader);

            Matcher lineMatcher = GETHEADRequest.matcher(requestLine);
            if (lineMatcher.matches()) {
                String method = lineMatcher.group(1);
                String uri = lineMatcher.group(2);
                String version = lineMatcher.group(3);

                boolean onlyHeader = "HEAD".equals(method);

                if (!("1.0".equals(version) || "1.1".equals(version)))
                    fail(writer, "501 Version not implemented "+version);
                else {
                    Result res = serve(uri);
                    res.addHeaders();

                    boolean keepAlive = shouldKeepAlive(headers, version);

                    writer.append("HTTP/")
                        .append(version)
                        .append(' ')
                        .append(res.getResultCode())
                        .append("\r\n")
                        .append(res.getHeaders());

                    if (keepAlive && "1.0".equals(version))
                        writer.append("Connection: keep-alive\r\n");
                    else if (!keepAlive && "1.1".equals(version))
                        writer.append("Connection: close\r\n");

                    writer.append("\r\n");

                    writer.flush();

                    if (!onlyHeader)
                        res.writeBody(os);

                    return keepAlive;
                }
            } else {
                System.err.printf("Bad Request: '%s'\n", requestLine);
                fail(writer, "400 Bad Request");
            }
        } catch(SocketTimeoutException e) {
            fail(writer, "408 Request Timeout");
        }

        writer.flush();
        writer.close();

        return false;
    }
}

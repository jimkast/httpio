package org.jimkast.http;

import java.io.IOException;

public class HttpException extends IOException {

    private final Number status;

    public HttpException(final int code) {
        super(Integer.toString(code));
        this.status = code;
    }

    public HttpException(final Number code, final String cause) {
        super(cause);
        this.status = code;
    }

    public HttpException(final Number code, final Throwable cause) {
        super(cause);
        this.status = code;
    }

    public HttpException(final Number code, final String msg, final Throwable cause) {
        super(msg, cause);
        this.status = code;
    }


    public final int code() {
        return this.status.intValue();
    }
}


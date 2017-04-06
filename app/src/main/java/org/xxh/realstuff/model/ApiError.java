package org.xxh.realstuff.model;

/**
 * @author xiexinhong (xiexinhong@meituan.com) on 16/11/18.
 */

public class ApiError {

    public boolean error;

    public String msg;

    public Throwable throwable;

    public ApiError(String msg, boolean error) {
        this.msg = msg;
        this.error = error;
    }

    public ApiError(Throwable throwable) {
        this.throwable = throwable;
    }
}

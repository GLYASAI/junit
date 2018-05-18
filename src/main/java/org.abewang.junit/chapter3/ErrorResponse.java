package org.abewang.junit.chapter3;

/**
 * @Author Abe
 * @Date 2018/5/18.
 */
public class ErrorResponse implements Response {
    private Request originalRequest;
    private Exception originalException;

    public ErrorResponse(Request originalRequest, Exception originalException) {
        this.originalRequest = originalRequest;
        this.originalException = originalException;
    }

    public Request getOriginalRequest() {
        return originalRequest;
    }

    public Exception getOriginalException() {
        return originalException;
    }
}

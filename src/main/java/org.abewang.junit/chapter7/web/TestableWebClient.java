package org.abewang.junit.chapter7.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author Abe
 * @Date 2018/5/21.
 */
public class TestableWebClient extends WebClient1 {
    private HttpURLConnection httpURLConnection;

    public void setHttpURLConnection(HttpURLConnection httpURLConnection) {
        this.httpURLConnection = httpURLConnection;
    }

    @Override
    public HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return httpURLConnection;
    }
}

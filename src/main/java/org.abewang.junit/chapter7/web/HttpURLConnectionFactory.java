package org.abewang.junit.chapter7.web;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author Abe
 * @Date 2018/5/21.
 */
public class HttpURLConnectionFactory implements ConnectionFactory {
    private URL url;

    public HttpURLConnectionFactory(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getData() throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        return httpURLConnection.getInputStream();
    }
}

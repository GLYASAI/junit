package org.abewang.junit.chapter7.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 用简单的方法重构WebClient
 *
 * @Author Abe
 * @Date 2018/5/21.
 */
public class WebClient1 {
    public String getContent(URL url) {
        StringBuilder s = new StringBuilder();
        try {
            HttpURLConnection conn = createHttpURLConnection(url);
            conn.setDoInput(true);
            InputStream is = conn.getInputStream();
            int count;
            while ((count = is.read()) != -1) {
                s.append(new String(Character.toChars(count)));
            }
        } catch (IOException e) {
            return null;
        }

        return s.toString();
    }

    public HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return (HttpURLConnection)url.openConnection();
    }
}

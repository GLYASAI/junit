package org.abewang.junit.chapter7.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 使用类工厂从后WebClient
 *
 * @Author Abe
 * @Date 2018/5/21.
 */
public class WebClient2 {
    public String getContent(ConnectionFactory connectionFactory) {
        StringBuilder s = new StringBuilder();
        try {
            InputStream is = connectionFactory.getData();
            int count;
            while ((count = is.read()) != -1) {
                s.append(new String(Character.toChars(count)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


        return s.toString();
    }
}

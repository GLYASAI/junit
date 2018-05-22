package org.abewang.junit.chapter7.web;

import java.io.InputStream;

/**
 * @Author Abe
 * @Date 2018/5/21.
 */
public class MockConnectionFactory implements ConnectionFactory {
    private InputStream inputStream;

    public void setData(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public InputStream getData() throws Exception {
        return inputStream;
    }
}

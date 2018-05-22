package org.abewang.junit.chapter7.web;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Abe
 * @Date 2018/5/22.
 */
public class MockInputStream extends InputStream {
    private String buffer;
    private int closeCount;
    private int position;

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    @Override
    public int read() {
        if (position == buffer.length()) {
            return -1;
        }
        return buffer.charAt(position++);
    }

    public void close() throws IOException {
        closeCount++;
        super.close();
    }

    public void verify() {
        if (closeCount != 1) {
            throw new AssertionError("close() should " +
                    "have been called once and once only");
        }
    }
}

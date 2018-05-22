package org.abewang.junit.chapter7.web;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author Abe
 * @Date 2018/5/21.
 */
public class TestWebClient2 {
    @Test
    public void testGetContentOk() {
        MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
        MockInputStream mockInputStream = new MockInputStream();
        mockInputStream.setBuffer("It works!");
        mockConnectionFactory.setData(mockInputStream);
        WebClient2 client = new WebClient2();
        String result = client.getContent(mockConnectionFactory);

        assertEquals("It works!", result);
        mockInputStream.verify();
    }
}

package org.abewang.junit.chapter7.web;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * @Author Abe
 * @Date 2018/5/21.
 */
public class TestWebClient1 {
    @Test
    public void testGetContentOk() throws MalformedURLException {
        TestableWebClient client = new TestableWebClient();
        MockHttpURLConnection mockConnection = new MockHttpURLConnection();
        mockConnection.setExpectedInputStream(new ByteArrayInputStream("It works".getBytes()));
        client.setHttpURLConnection(mockConnection);
        String result = client.getContent(new URL("http://localhost"));
        assertEquals("It works", result);
    }
}

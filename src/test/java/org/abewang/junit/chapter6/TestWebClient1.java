package org.abewang.junit.chapter6;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.*;

import static org.junit.Assert.assertEquals;

/**
 * @Author Abe
 * @Date 2018/5/20.
 */
public class TestWebClient1 {
    @BeforeClass
    public static void setUp() {
        TestWebClient1 t = new TestWebClient1();
        URL.setURLStreamHandlerFactory(t.new StubStreamHandlerFactory());
    }

    private class StubStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }

    private class StubHttpURLStreamHandler extends URLStreamHandler {
        protected URLConnection openConnection(URL u) throws IOException {
            return new StubHttpURLConnection(u);
        }
    }

    @Test
    public void testGetConnectOK() throws MalformedURLException {
        WebClient client = new WebClient();
        String result = client.getContent( new URL( "http://localhost/" ) );
        assertEquals( "It works", result );
    }
}

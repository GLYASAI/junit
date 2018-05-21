package org.abewang.junit.chapter6;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @Author Abe
 * @Date 2018/5/20.
 */
public class TestWebClient {
    @BeforeClass
    public static void setUp() throws Exception {
        Server server = new Server(8080);

        TestWebClient t = new TestWebClient();
        Context contextGetConnectOK = new Context(server, "/testGetConnectOK");
        contextGetConnectOK.setHandler(t.new TestGetContentOkHandler());

        Context contextURLNotFound = new Context(server, "/testURLNotFound");
        contextURLNotFound.setHandler(t.new TestURLNotFoundHandler());

        server.setStopAtShutdown(true);
        server.start();
    }

    @AfterClass
    public void tearDown() {
        // Empty
    }

    @Test
    public void testGetConnectOK() throws MalformedURLException {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetConnectOK"));
        assertEquals("It works!", result);
    }

    @Test
    public void testURLNotFound() throws MalformedURLException {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testURLNotFound"));
        assertNull(result);
    }

    /**
     * 自定义的处理器
     */
    private class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest request, HttpServletResponse response,
                           int dispatch) throws IOException, ServletException {
            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works!");
            writer.flush();
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    private class TestURLNotFoundHandler extends AbstractHandler {
        @Override
        public void handle(String target, HttpServletRequest request, HttpServletResponse response,
                           int dispatch) throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

package org.abewang.junit.chapter7.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.easymock.EasyMock.*;

/**
 * @Author Abe
 * @Date 2018/5/22.
 */
public class TestWebClientEasyMock {
    private ConnectionFactory factory;
    private InputStream stream;

    @Before
    public void setUp() {
        factory = createMock("factory", ConnectionFactory.class);
        stream = createMock("stream", InputStream.class);
    }

    @Test
    public void testGetContentOk() throws Exception {
        expect(factory.getData()).andReturn(stream);
        expect(stream.read()).andReturn((int) (byte) 'W');
        expect(stream.read()).andReturn((int) (byte) 'o');
        expect(stream.read()).andReturn((int) (byte) 'r');
        expect(stream.read()).andReturn((int) (byte) 'k');
        expect(stream.read()).andReturn((int) (byte) 's');
        expect(stream.read()).andReturn((int) (byte) '!');
        expect(stream.read()).andReturn(-1);

        stream.close();
        replay(stream);
        replay(factory);

        WebClient2 client = new WebClient2();
        String result = client.getContent(factory);
        assertEquals("Works!", result);
    }

    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {
        expect(factory.getData()).andReturn(stream);
        expect(stream.read()).andReturn(-1);
        stream.close();
        expectLastCall().andThrow(new IOException("cannot close"));

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();
        String result = client.getContent(factory);
        assertNull(result);
    }

    @After
    public void tearDown() {
        verify(factory);
        verify(stream);
    }
}

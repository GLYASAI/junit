package org.abewang.junit.chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * 测试DefaultController
 *
 * @Author Abe wang
 * @Date 5/18/2018.
 */
public class TestDefaultController {
    private DefaultController controller;
    private SampleRequest request;
    SampleRequestHandler handler;

    @Before  // @Before/@After注释的方法会发生在每一个＠Test方法的之前／之后，并且不管测试是遥远还是失败。
    public void initialize() throws Exception {
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleRequestHandler();

        controller.addHandler(request, handler);
    }

    @Test
    public void testGetHandler() {
        assertSame("The handler we set in controller should be the same handler we get",
                handler, controller.getHandler(request));
    }

    @Test
    public void testProcessRequest() {
        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response", response);
        assertEquals("Response should be type of SampleResponse",
                SampleResponse.class, response.getClass());
    }

    private class SampleRequest implements Request {
        @Override
        public String getName() {
            return "Test";
        }
    }

    private class SampleRequestHandler implements RequestHandler {
        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {

    }
}

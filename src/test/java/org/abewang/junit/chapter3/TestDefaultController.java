package org.abewang.junit.chapter3;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertEquals(new SampleResponse(), response);
    }

    @Test
    public void testProcessRequestAnserErrorResponse() {
        SampleRequest request = new SampleRequest("testError");
        SampleExceptionHandler handler = new SampleExceptionHandler();
        controller.addHandler(request, handler);
        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response", response);
        assertEquals(new SampleResponse(), response);
    }

    @Test(expected = RuntimeException.class)  // 预期这个测试方法将会产生RuntimeException
    public void testGetHandlerNotDefined() {
        SampleRequest request = new SampleRequest("testNotDefined");
        controller.getHandler(request);
    }

    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicatedName() {
        SampleRequest request = new SampleRequest();
        RequestHandler handler = new SampleRequestHandler();
        controller.addHandler(request, handler);
    }

    @Test(timeout = 130)  // 以毫秒为单位指定timeout参数
    @Ignore(value = "Ignore for now until we decide a decent time-limit")
    public void testProcessMultipleRequestsTimeout() {
        for (int i = 0; i < 99999; i++) {
            request = new SampleRequest(String.valueOf(i));
            controller.addHandler(request, handler);
            Response response = controller.processRequest(request);
            assertNotNull(response);
            assertNotSame(ErrorResponse.class, response.getClass());
        }
    }

    private class SampleRequest implements Request {
        private static final String DEFAULT_NAME = "Test";

        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }

        public SampleRequest() {
            this(DEFAULT_NAME);
        }

        @Override
        public String getName() {
            return name;
        }
    }

    private class SampleRequestHandler implements RequestHandler {
        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleExceptionHandler implements RequestHandler {
        @Override
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request");
        }
    }

    private class SampleResponse implements Response {
        private static final String Name = "Test";

        public String getName() {
            return Name;
        }

        @Override
        public int hashCode() {
            return Name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            if (obj instanceof SampleResponse) {
                result = ((SampleResponse) obj).getName().equals(Name);
            }
            return result;
        }
    }
}

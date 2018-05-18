package org.abewang.junit.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Abe
 * @Date 2018/5/18.
 */
public class DefaultController implements Controller {
    /**
     * 请求处理器的注册表
     */
    private Map<String, RequestHandler> requestHandlers = new HashMap<>();

    /**
     * 为接收的请求获取requestHandler
     *
     * @param request 请求
     * @return request对于的requestHandler
     */
    protected RequestHandler getHandler(Request request) {
        if (!requestHandlers.containsKey(request.getName())) {
            String msg = "Can not find requestHandler [" + request.getName() + "]";
            throw new RuntimeException(msg);  // 可以改进为NoSuitableRequestHandlerException
        }

        return requestHandlers.get(request.getName());
    }

    /**
     * Controller的核心
     *
     * @param request 请求
     * @return 返回
     */
    @Override
    public Response processRequest(Request request) {
        Response response;
        try {
            response = getHandler(request).process(request);
        } catch (Exception e) {
            response = new ErrorResponse(request, e);
        }
        return response;
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if (requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has already been registered " +
                    "by request name [" + request.getName() + "]");
        }
        requestHandlers.put(request.getName(), requestHandler);
    }
}

package org.abewang.junit.chapter3;

/**
 * 顶层方法，接收请求并转发到RequestHandler
 *
 * @Author Abe
 * @Date 2018/5/18.
 */
public interface Controller {
    Response processRequest(Request request);

    void addHandler(Request request, RequestHandler requestHandler);
}

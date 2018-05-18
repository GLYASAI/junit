package org.abewang.junit.chapter3;

/**
 * 辅助插件，用于处理大部分"肮脏"工作
 *
 * @Author Abe
 * @Date 2018/5/18.
 */
public interface RequestHandler {
    Response process(Request request) throws Exception;
}

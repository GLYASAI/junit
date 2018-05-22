package org.abewang.junit.chapter7.web;

import java.io.InputStream;

/**
 * @Author Abe
 * @Date 2018/5/21.
 */
public interface ConnectionFactory {
    InputStream getData() throws Exception;
}

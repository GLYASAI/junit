package org.abewang.junit.chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 使用JUnit编写CalculatorTest程序
 *
 * @Author Abe
 * @Date 2018/5/17.
 */
public class CalculatorTest {  // 这个类必须是公有的，通常在类后面加Test
    @Test
    public void testAdd() {  // 测试方法必须是公共的，最好用testXXX()的方式命名
        Calculator cal = new Calculator();
        assertEquals(60, cal.add(10, 50), 0);
    }
}

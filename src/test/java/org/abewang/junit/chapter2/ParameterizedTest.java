package org.abewang.junit.chapter2;

import org.abewang.junit.chapter1.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


/**
 * 运行参数化测试
 *
 * @Author Abe
 * @Date 2018/5/17.
 */
@RunWith(Parameterized.class)  // Parameterized测试运行器允许你使用不同的参数多次运行同一个测试
public class ParameterizedTest {
    private double expected;
    private double valueOne;
    private double valueTwo;

    // 签名必须是@Parameters public static Collection，无任何参数
    @Parameters
    public static Collection<Integer[]> getParameters() {  // 运行1次
        return Arrays.asList(new Integer[][]{
                {2, 1, 1},
                {4, 3, 1},
                {5, 2, 3},
        });
    }

    public ParameterizedTest(double expected, double valueOne, double valueTwo) {  // 运行3次
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum() {  // 运行3次
        Calculator cal = new Calculator();
        assertEquals(expected, cal.add(valueOne, valueTwo), 0);
    }
}

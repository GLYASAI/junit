package org.abewang.junit.chapter3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Author Abe wang
 * @Date 5/18/2018.
 */
public class HamcrestTest {
    private ArrayList<String> values;

    @Before
    public void setUpList() {
        values = new ArrayList<>();
        values.add("X");
        values.add("Y");
        values.add("Z");
    }

    @Test
    public void testWithoutHamcrest() {
        assertTrue(values.contains("one")
                || values.contains("Two")
                || values.contains("Three"));
    }

    @Test
    public void testWithHamcrest() {
        assertThat(values, hasItem(anyOf(equalTo("one"), equalTo("two"),
                equalTo("three"))));
    }
}

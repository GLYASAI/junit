package org.abewang.junit.chapter2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses ;

/**
 * @Author Abe
 * @Date 2018/5/18.
 */
@RunWith(Suite.class)
@SuiteClasses(value = {TestCastA.class, TestCastB.class})
public class MasterTestSuite {

}

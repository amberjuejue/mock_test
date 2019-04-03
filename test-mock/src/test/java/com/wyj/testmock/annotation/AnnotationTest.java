package com.wyj.testmock.annotation;

import org.junit.*;

/**
 * @author wangyujue
 */
public class AnnotationTest {

    @Before
    public void testBefor() {
        System.out.println("我是before");
    }
    @BeforeClass
    public static void testBeforClass() {
        System.out.println("我是beforeClass");
    }
    @Test
    public void test() {
        System.out.println("我是test-----");
    }
    @Test
    public void test1() {
        System.out.println("我是test1-----");
    }
    @Test(timeout = 1000)
    public void testTimeOut() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(expected = NullPointerException.class)
    public void testTimeException() {
        throw new RuntimeException("我是异常");
    }
    @After
    public void testAfter() {
        System.out.println("我是after");
    }
    @AfterClass
    public static void testAfterClass() {
        System.out.println("我是afterClass");
    }

}

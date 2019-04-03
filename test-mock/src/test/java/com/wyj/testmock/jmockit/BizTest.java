package com.wyj.testmock.jmockit;

import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class BizTest {

    Biz biz = new Biz();

    //@Mocked与@Injectable的区别：前者针对类型，后者针对单个实例。
    @Injectable
    Dao dao;

    @Before
    public void setUp() {
        biz.setDao(dao);
    }

    @Test
    public void insert() {
        biz.insert("111","Name","student");



        new Expectations() {
            {
                dao.insert((BeanEntity) any);
                result = 0;
                times = 12;
            }
        };
        Assert.assertEquals(0, biz.insert("1", "1", "1"));
        new Verifications() {
            {
                dao.insert((BeanEntity) any);
                times = 2;
            }
        };
    }

//    @Mocked
//    ClassA classA;
    /**
     * mock私有方法
     */
    @Test
    public void testPrivateMethod() {

        final ClassA a = new ClassA();
        // 局部参数，把a传进去
        Deencapsulation.invoke(a, "getAnythingPrivate");

        Assert.assertEquals(1, a.getAnything());

        new Verifications() {
            {
                Deencapsulation.invoke(a, "getAnythingPrivate");
                times = 1;
            }
        };
    }

    /**
     * mock私有属性
     */
    @Test
    public void testPrivateField() {

        final ClassA a = new ClassA();
        // 局部参数，把a传进去
        Deencapsulation.setField(a, "url", "www.baidu.com");

        Assert.assertEquals("www.baidu.com", a.print());

//        new Verifications() {
//            {
//                Deencapsulation.invoke(a, "getAnythingPrivate");
//                times = 1;
//            }
//        };
    }

    @Test
    public void remove() {
    }

    @Test
    public void update() {
    }

    @Test
    public void finds() {
    }

    @Test
    public void getDao() {
    }

    @Test
    public void setDao() {
    }
}
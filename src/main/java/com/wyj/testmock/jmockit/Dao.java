package com.wyj.testmock.jmockit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wangyujue
 */
public class Dao {
    public int insert(BeanEntity beanEntity) {
        System.out.println("Dao insert");
        return 1;
    }

    public void remove(String id) {
        System.out.println("Dao remove");
    }

    public void update(String name, String type) {
        System.out.println("Dao update");
    }

    public List<BeanEntity> find(String name) {
        System.out.println("Dao finds");
        BeanEntity bean = new BeanEntity();
        bean.setBeanId("24336461423");
        bean.setBeanName("张三");
        bean.setBeanType("学生");
        return Collections.singletonList(bean);
    }

}

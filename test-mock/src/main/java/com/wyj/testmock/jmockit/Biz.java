package com.wyj.testmock.jmockit;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author wangyujue
 */
public class Biz {

    private Dao dao;


    public int insert(String id, String name, String type) {

        if (StringUtils.isAnyBlank(id, name, type)) {
            return 0;
        }

        BeanEntity bean = new BeanEntity();
        bean.setBeanType(type);
        bean.setBeanId(id);
        bean.setBeanName(name);
        return dao.insert(bean);
    }

    public void remove(String id) {
        if (StringUtils.isBlank(id)) {
            return;
        }
        dao.remove(id);
    }

    public void update(String name, String type) {
        if (StringUtils.isAnyBlank(name, type)) {
            return;
        }
        dao.update(name, type);
    }

    public String finds(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        List<BeanEntity> beans = dao.find(name);

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (BeanEntity bean : beans) {
            sb.append(bean.getBeanType()).append("#");
        }

        return sb.toString();
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}

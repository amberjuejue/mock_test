package com.wyj.testmock.jmockit;

/**
 * @author wangyujue
 */
public class ClassA {

    private String url = "";

    public int getAnything() {
        return getAnythingPrivate();
    }

    private int getAnythingPrivate() {
            return 1;
    }

    public String print() {
        System.out.println("call print");
        return this.url;
    }
}

package com.wyj.testmock.mockito;

/**
 * @author wangyujue
 */
public class MockitoClass {

    public static int getInt() {
        return 1;
    }

    public int method() {
        // toto find in db
        int random = (int) (Math.random() * 100);
        System.out.println(random);
        if (random == 1) {
            return 1;
        }
        return 0;
    }

    public void voidMethod() {
        System.out.println("void_method");
    }

    public int matcherMethod(int i) {
        return i;
    }

    public int spyMethod(int i) {
        return i;
    }
}

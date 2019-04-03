package com.wyj.testmock.mockito;

/**
 * @author wangyujue
 */
public class MockitoTest {

    public void timeout() {
        try {
            Thread.sleep(99);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.wyj.testmock.jmock;

import junit.framework.TestCase;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class UserManagerTest extends TestCase {

    private Mockery context = new JUnit4Mockery();

    private IAddressService addressService = null;

    private UserManager userManager = null;

    @Before
    public void setup() throws Exception {
        super.setUp();
        addressService = context.mock(IAddressService.class);
        userManager = new UserManager(addressService);
        context.checking(new Expectations() {
            {
//                  oneOf()
                try {
                    exactly(1).of(addressService).findAddress("wyj");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                will(returnValue("nanjing"));
            }
        });
    }


    @Test
    public void getCityCode() {
        assertEquals(1, userManager.getCityCode("wyj001"));
    }
}
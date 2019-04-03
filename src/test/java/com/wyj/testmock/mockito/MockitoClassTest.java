package com.wyj.testmock.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoClassTest {

    @Test
    public void method() {
        MockitoClass mc = mock(MockitoClass.class);
        // #1.方式1
        doReturn(1).when(mc).method();
        // #2.方式2
        when(mc.method()).thenReturn(1);
        assertEquals(1, mc.method());
        assertEquals(1, mc.method());
        verify(mc, times(2)).method();
    }

    @Test(expected = RuntimeException.class)
    public void methodException() {
        MockitoClass mc = mock(MockitoClass.class);
        // #1.方式1
        when(mc.method()).thenThrow(RuntimeException.class);
        // #2.方式2
        doThrow(RuntimeException.class).when(mc.method());
        mc.method();
    }

    @Test
    public void methodDoNoting() {
        MockitoClass mc = mock(MockitoClass.class);
        Mockito.doNothing().when(mc).voidMethod();
        mc.voidMethod();
        verify(mc, times(1)).voidMethod();
    }

    @Test(expected = RuntimeException.class)
    public void methodDoNotingException() {
        MockitoClass mc = mock(MockitoClass.class);
        Mockito.doThrow(RuntimeException.class).when(mc).voidMethod();
        mc.voidMethod();
    }

    @Test
    public void methodMatcher() {
        MockitoClass mc = mock(MockitoClass.class);
        when(mc.matcherMethod(anyInt())).thenReturn(2);
        assertEquals(2, mc.matcherMethod(5));
        verify(mc, times(1)).matcherMethod(anyInt());
    }

    @Test
    public void spyMethod() {
        MockitoClass mc = mock(MockitoClass.class);
        when(mc.spyMethod(anyInt())).thenReturn(2);
        assertEquals(2, mc.spyMethod(5));
        assertEquals(5, mc.spyMethod(5));
    }

    @Test
    public void staticMethodTest() {
        MockitoClass mc = mock(MockitoClass.class);
        when(mc.getInt()).thenReturn(2);
        assertEquals(2, mc.spyMethod(5));
        assertEquals(5, mc.spyMethod(5));
    }
}
package com.wyj.testmock.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockitoTestTest {


    @Test
    public void test() {
        ArrayList mockList = Mockito.mock(ArrayList.class);
        assertTrue(mockList instanceof ArrayList);
        when(mockList.add("张三")).thenReturn(true);
        assertTrue(mockList.add("张三"));
        assertFalse(mockList.add("李四"));
        when(mockList.size()).thenReturn(10);
        assertEquals(mockList.size(), 10);
        assertNotSame(mockList.size(), 20);
        assertNull(mockList.get(0));

        ArrayList mockList2 = mock(ArrayList.class);
        mockList2.add("once");
        mockList2.add("twice");
        mockList2.add("twice");
        mockList2.add("three times");
        mockList2.add("three times");
        mockList2.add("three times");

        verify(mockList2).add("once");
        verify(mockList2, times(2)).add("twice");
        verify(mockList2, times(3)).add("three times");
        // error代码
//        verify(mockList2, times(3)).add("twice");

        verify(mockList2, never()).add("never");

        verify(mockList2, atLeastOnce()).add("once");

        verify(mockList2, atLeast(2)).add("three times");
        verify(mockList2, atMost(5)).add("three times");

        MockitoTest mock = mock(MockitoTest.class);
//        timeout(100);
//        mock.timeout();
        verify(mock, timeout(100)).timeout();
        verify(mock, timeout(100).times(1)).timeout();
        //方法2次调用均没超过100ms
        verify(mock, timeout(100).times(2)).timeout();
        verify(mock, timeout(100).atLeast(2)).timeout();
    }

}
package com.skillsoft.mocks;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;



public class ArrayListMock {

    @Test
    public void mockArrayList(){

        ArrayList someArrayList = mock(ArrayList.class);

        when(someArrayList.contains("Alice")).thenReturn(true);
        when(someArrayList.contains("Bob")).thenReturn(false);

        assertTrue(someArrayList.contains("Alice"));
        assertFalse(someArrayList.contains("Bob"));

        when(someArrayList.get(0)).thenReturn("Alice");
        when(someArrayList.get(1)).thenReturn("Bob");
        when(someArrayList.get(2)).thenReturn("Charles");

        assertEquals("Alice", someArrayList.get(0));
        assertEquals("Bob", someArrayList.get(1));
        assertEquals("Charles", someArrayList.get(2));

        when(someArrayList.indexOf("Alice")).thenReturn(100);
        when(someArrayList.indexOf("Bob")).thenReturn(101);
        when(someArrayList.indexOf("Charles")).thenReturn(102);

        assertEquals(100, someArrayList.indexOf("Alice"));
        assertEquals(101, someArrayList.indexOf("Bob"));
        assertEquals(102, someArrayList.indexOf("Charles"));

        when(someArrayList.subList(100, 103)).thenReturn(Arrays.asList("Alice", "Bob", "Charles"));
        when(someArrayList.subList(1000, 1003)).thenReturn(Arrays.asList("Xavier", "Yasmin", "Zoe"));

        assertLinesMatch(Arrays.asList("Alice", "Bob", "Charles"), someArrayList.subList(100, 103));
        assertLinesMatch(Arrays.asList("Xavier", "Yasmin", "Zoe"), someArrayList.subList(1000,1003));

    }

//    @Test
//    public void mockArrayList(){
//
//        ArrayList someArrayList = mock(ArrayList.class);
//
//        when(someArrayList.isEmpty()).thenReturn(true);
//        when(someArrayList.size()).thenReturn(23);
//        when(someArrayList.toArray()).thenReturn(new Object[]{1,3,6,9});
//
//        assertTrue(someArrayList.isEmpty());
//        assertEquals(23,someArrayList.size());
//        assertArrayEquals(new Object[]{1,3,6,9}, someArrayList.toArray());
//    }

}

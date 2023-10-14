package org.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnit4ClassRunner.class)
public class MyArrayListTest {
    private MyArrayList<String> myArrayList;
    @Before
    public void setup() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    public void testAddAndSize() {
        // Test the add() method and size()
        assertEquals(0, myArrayList.size());
        myArrayList.add("One");
        assertEquals(1, myArrayList.size());
        myArrayList.add("Two");
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testRemove() {
        // Test the remove() method
        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add("Three");

        // Verify that the element is removed
        assertTrue(myArrayList.remove("Two"));
        // Verify the size after removal
        assertEquals(2, myArrayList.size());
        // Verify the elements that remain
        assertTrue(myArrayList.contains("One"));
        assertTrue(myArrayList.contains("Three"));
    }
    @Test
    public void testSizeAfterAdd() {
        // Test the size() method after adding elements
        assertEquals(0, myArrayList.size());
        myArrayList.add("One");
        assertEquals(1, myArrayList.size());
        myArrayList.add("Two");
        assertEquals(2, myArrayList.size());
        myArrayList.add("Three");
        assertEquals(3, myArrayList.size());
    }

    @Test
    public void testSizeAfterRemove() {
        // Test the size() method after removing elements
        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add("Three");

        assertEquals(3, myArrayList.size());

        // Remove an element
        myArrayList.remove("Two");
        assertEquals(2, myArrayList.size());

        // Remove another element
        myArrayList.remove("One");
        assertEquals(1, myArrayList.size());
    }


}
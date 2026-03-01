package com.sqe.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderProcessorTest {

    OrderProcessor processor = new OrderProcessor();


    @Test
    void testNullArray() {
        assertEquals("Invalid", processor.findOrder(null, 101, "fast"));
    }

    @Test
    void testNullTarget() {
        int[] ids = {1, 2, 3};
        assertEquals("Invalid", processor.findOrder(ids, null, "fast"));
    }


    @Test
    void testBinarySearchPath() {
        int[] ids = {10,20,30,40,50,60,70,80,90,100,110};
        assertEquals("Found", processor.findOrder(ids, 50, "fast"));
    }

    @Test
    void testLinearShortArray() {
        int[] ids = {10,20,30};
        assertEquals("Found", processor.findOrder(ids, 30, "fast"));
    }

    @Test
    void testLinearSlowMode() {
        int[] ids = {10,20,30,40,50,60,70,80,90,100,110};
        assertEquals("Found", processor.findOrder(ids, 20, "slow"));
    }

    @Test
    void testJumpSearchMode() {
        int[] ids = {10,20,30,40,50,60,70,80,90,100,110};
        assertEquals("Found", processor.findOrder(ids, 70, "jump"));
    }

    @Test
    void testNotFound() {
        int[] ids = {10,20,30};
        assertEquals("Not Found", processor.findOrder(ids, 99, "fast"));
    }
}
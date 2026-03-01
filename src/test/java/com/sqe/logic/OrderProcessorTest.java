package com.sqe.logic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderProcessorTest {
    OrderProcessor processor = new OrderProcessor();

    @Test
    void testMCDC_NullArray() {
        assertEquals("Invalid", processor.findOrder(null, 101, "fast"));
    }

    @Test
    void testMCDC_NullTarget() {
        int[] ids = {1, 2, 3};
        assertEquals("Invalid", processor.findOrder(ids, null, "fast"));
    }

    @Test
    void testBinaryPath_Success() {
        // Mode "fast" AND length > 10 (Both True)
        int[] ids = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        assertEquals("Found", processor.findOrder(ids, 50, "fast"));
    }

    @Test
    void testLinearPath_ShortArray() {
        // Mode "fast" BUT length <= 10
        int[] ids = {10, 20, 30};
        assertEquals("Found", processor.findOrder(ids, 30, "fast"));
    }

    @Test
    void testLinearPath_SlowMode() {
        // Mode is NOT "fast"
        int[] ids = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        assertEquals("Found", processor.findOrder(ids, 20, "slow"));
    }

    @Test
    void testNotFound() {
        int[] ids = {10, 20, 30};
        assertEquals("Not Found", processor.findOrder(ids, 99, "fast"));
    }
}
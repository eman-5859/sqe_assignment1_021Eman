package com.sqe.logic;

public class OrderProcessor {
    private SearchLibrary searcher = new SearchLibrary();

    public String findOrder(int[] orderIds, Integer targetId, String mode) {
        // Decision 1: Input Validation (Null Checks)
        if (orderIds == null || targetId == null) {
            return "Invalid";
        }

        int result;
        // Decision 2: Search Mode Selection
        // For MC/DC: We test both conditions (mode and length)
        if ("fast".equals(mode) && orderIds.length > 10) {
            result = searcher.binarySearch(orderIds, targetId);
        } else {
            result = searcher.linearSearch(orderIds, targetId);
        }

        return (result != -1) ? "Found" : "Not Found";
    }
}
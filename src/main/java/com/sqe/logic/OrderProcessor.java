package com.sqe.logic;

public class OrderProcessor {

    private SearchLibrary searcher = new SearchLibrary();

    public String findOrder(int[] orderIds, Integer targetId, String mode) {

        if (orderIds == null || targetId == null) {
            return "Invalid";
        }

        int result;

        if ("fast".equals(mode) && orderIds.length > 10) {

            result = searcher.binarySearch(targetId, orderIds);

        } else if ("jump".equals(mode)) {

            result = searcher.jumpSearch(orderIds, targetId);

        } else {

            result = searcher.linearSearch(orderIds, targetId);
        }
        return (result != -1) ? "Found" : "Not Found";
    }
}
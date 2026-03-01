package com.sqe.logic;

public class SearchLibrary {

    // 1️ Binary Search 
    public int binarySearch(int key, int[] elemArray) {

        int bottom = 0;
        int top = elemArray.length - 1;
        int mid;
        int index = -1;
        boolean found = false;

        while (bottom <= top && found == false) {

            mid = (top + bottom) / 2;

            if (elemArray[mid] == key) {
                index = mid;
                found = true;
                return index;
            } 
            else {
                if (elemArray[mid] < key)
                    bottom = mid + 1;
                else
                    top = mid - 1;
            }
        }

        return index;
    }

    // 2️ Linear Search
    public int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }

        return -1;
    }

    // 3️ Jump Search 
    public int jumpSearch(int[] arr, int key) {

        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;
      
        while (prev < n && arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        while (prev < Math.min(step, n)) {
            if (arr[prev] == key)
                return prev;
            prev++;
        }

        return -1;
    }
}
package com.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1 {
    /*
    a. break the array into two: one sorted array and one unsorted array e.g. [1, 3, 5, 12] and [6, 4, 2].
    This takes O(n) b. Sort the unsorted array. This takes O(klogk) c. Merge two sorted arrays.
    This takes O(n). Because k is very small, so in the end O(n) + O(klogk) ~= O(n).
     */
    public int[] sortArray(int[] arr) {
        int N = arr.length;
        if(N == 0) return arr;

        List<Integer> sorted = new ArrayList<>();
        List<Integer> unSorted = new ArrayList<>();

        for(int n : arr) {
            if(sorted.isEmpty() || n >= sorted.get(sorted.size()-1)) {
                sorted.add(n);
            } else {
                unSorted.add(n);
            }
        }

        if(!unSorted.isEmpty()) {
            Collections.sort(unSorted);
        }

        int[] res = new int[N];
        int cur = 0;
        int i=0, j=0;
        while(i<sorted.size() || j<unSorted.size()) {
            if(i==sorted.size()
                    || (i<sorted.size() && j<unSorted.size()
                    && unSorted.get(j) <= sorted.get(i))) {
                res[cur++] = unSorted.get(j++);
            } else {
                res[cur++] = sorted.get(i++);
            }
        }
        return res;
    }
}

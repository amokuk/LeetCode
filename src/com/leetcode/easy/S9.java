package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class S9 {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        List<Integer> tempList = new ArrayList<>();
        while(x != 0) {
            tempList.add(x % 10);
            x /= 10;
        }

        for(int i=0; i<tempList.size()/2; i++) {
            if(tempList.get(i) != tempList.get(tempList.size() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindromeOptimized(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int temp = 0;
        while(temp < x) {
            temp *= 10;
            temp += x % 10;
            x /= 10;
        }

        return temp == x || temp / 10 == x;
    }
}

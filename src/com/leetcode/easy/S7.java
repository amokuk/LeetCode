package com.leetcode.easy;

public class S7 {
    public int reverse(int x) {
        int ret = 0;
        while(x != 0) {
            int temp = x % 10;
            x /= 10;

            if(ret > (Integer.MAX_VALUE / 10) || ret < (Integer.MIN_VALUE / 10)) {
                return 0;
            }

            if((ret == (Integer.MAX_VALUE / 10) && temp > 7) || (ret == (Integer.MIN_VALUE / 10) && temp < -8)) {
                return 0;
            }

            ret *= 10;
            ret += temp;
        }

        return ret;
    }
}

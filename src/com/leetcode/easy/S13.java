package com.leetcode.easy;

import java.util.HashMap;

public class S13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = getDirectory();
        int ret = 0;
        for(int i=0; i<s.length(); i++) {
            if(i == s.length() - 1 ||
                    map.get(s.charAt(i)) >= map.get(s.charAt(i+1))
            ) {
                ret += map.get(s.charAt(i));
            } else {
                ret -= map.get(s.charAt(i));
            }
        }
        return ret;
    }

    public int romanToIntMoreMemoryFaster(String s) {
        HashMap<Character, Integer> map = getDirectory();
        int ret = 0;
        for(int i=0; i<s.length(); i++) {
            int v1 = map.get(s.charAt(i));
            if(i == s.length() -1) {
                ret += v1;
            } else {
                int v2 = map.get(s.charAt(i+1));
                if(v1 >= v2) {
                    ret += v1;
                } else {
                    ret -= v1;
                }
            }
        }
        return ret;
    }

    private HashMap getDirectory() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}

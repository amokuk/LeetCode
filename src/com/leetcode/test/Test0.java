package com.leetcode.test;

import com.leetcode.easy.S13;
import com.leetcode.easy.S14;
import com.leetcode.easy.S7;
import com.leetcode.easy.S9;

public class Test0 {
    public void t7() {
        S7 s7 = new S7();
        System.out.println(s7.reverse(123));
        System.out.println(s7.reverse(-123));
        System.out.println(s7.reverse(120));
        System.out.println(s7.reverse(1463847412));
    }

    public void t9() {
        S9 s9 = new S9();
        System.out.println(s9.isPalindrome(121));
        System.out.println(s9.isPalindrome(-121));
        System.out.println(s9.isPalindrome(10));

        System.out.println(s9.isPalindromeOptimized(121));
        System.out.println(s9.isPalindromeOptimized(-121));
        System.out.println(s9.isPalindromeOptimized(10));
    }

    public void t13() {
        S13 s = new S13();
        System.out.println(s.romanToInt("III"));
        System.out.println(s.romanToInt("IV"));
        System.out.println(s.romanToInt("IX"));
        System.out.println(s.romanToInt("LVIII"));
        System.out.println(s.romanToInt("MCMXCIV"));
    }

    public void t14() {
        S14 s = new S14();
        System.out.println(s.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(s.longestCommonPrefixV(new String[]{"flower","flow","flight"}));
        System.out.println(s.longestCommonPrefixVSimple(new String[]{"flower","flow","flight"}));
    }
}

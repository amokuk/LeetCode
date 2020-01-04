package com.leetcode.test;

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
}

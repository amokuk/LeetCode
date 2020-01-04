package com.leetcode.main;

import com.leetcode.test.Test0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int testNo = 14;
        if(testNo < 100) {
            Test0 test0 = new Test0();
            Method method = test0.getClass().getMethod("t" + testNo);
            method.invoke(test0);
        }
    }
}

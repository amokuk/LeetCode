package com.main;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(a -> System.out.print(a + ", "));
        System.out.println();
    }
}

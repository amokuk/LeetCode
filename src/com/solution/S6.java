package com.solution;

import java.util.*;

public class S6 {
    public static void main(String[] args) {
        S6 s = new S6();

        int c = 0;
        for(int i=0; i<100000; i++) {
            if(s.randomBoolean(0.5)) {
                c++;
            }
        }
        System.out.println(c);
    }

    private boolean randomBoolean(double p) {
        int r = 0, m = 0;

        int i = 0;
        //其实就是用两个数来模拟random的方法
        while(i < 20) {
            r <<= 1;
            r |= randomBoolean() ? 1 : 0;
            m <<= 1;
            m |= 1;
            i++;
        }

        return r*1.0/m*1.0 <= p;
    }

    Random random = new Random();
    private boolean randomBoolean() {
        return random.nextInt() % 2 == 0;
    }
}

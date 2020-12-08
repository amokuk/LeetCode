package com.solution;

public class S3 {
    public static void main(String[] args) {
        S3 s = new S3();
        System.out.println(s.hasSequence(new int[]{1,2,3,4,7,8,9}, 3));
        System.out.println(s.hasSequence(new int[]{1,2,4,7,8,9}, 3));
        System.out.println(s.hasSequence(new int[]{1,2,3,7,8,9}, 3));
        System.out.println(s.hasSequence(new int[]{1,2,3,4,5,6,9}, 3));
    }

    public int hasSequence(int[] array, int k) {
        int N = array.length;
        if(N < 2*k || k < 0) return -1;
        if(N == 0 || k == 0) return 0;

        boolean validHalf = false;
        int count = 1;
        for(int i=1; i<N; i++) {
            if(array[i]-1 == array[i-1]) {
                count++;
                if((count == k && validHalf) || count == 2*k) return i-(2*k)+1;
            } else {
                validHalf = count>=k;
                count = 1;
            }
        }
        return -1;
    }
}

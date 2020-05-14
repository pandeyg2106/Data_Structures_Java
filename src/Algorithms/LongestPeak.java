package Algorithms;

import java.util.Arrays;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        // Write your code here.
        int start = 0;
        int peak = 1;
        int result = 0;
        int count = 0;
        int len = array.length;
        if (len < 1) {
            return 0;
        }
        if (len < 3) {
            return -1;
        }
        while (start < len - 1) {
            if (array[start] < array[start + 1]) {
                if (count > 0) {
                    peak = 1;
                    count = 0;
                }
                start++;
                peak++;
            } else if (array[start] > array[start + 1] && peak > 1) {
                peak++;
                result = Math.max(peak, result);
                start++;
                count++;
            } else {
                start++;
                peak = 1;
            }
        }
        return result;
    }

    //10,4,6,2, 3, 5  7
    public static int test(int[] A, int num) {
        Arrays.sort(A);
        int start = 0;
        int len = A.length;
        int end = len - 1;
        int sum = 0;
        int count = 0;
        while (end >= 0) {
            if (A[len - 1] > num)
                end--;
            else
                break;
        }
        if (end < 0)
            return 0;
        for (int i = 0; i < len; i++) {

        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(A));
    }

}

package Algorithms.Dynamic_Programming;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int len1 = arrayOne.length;
        int len2 = arrayTwo.length;
        int diff = Integer.MAX_VALUE;
        int start1 = 0;
        int start2 = 0;
        int[] result = new int[2];
        while (start1 < len1 && start2 < len2) {
            if (arrayOne[start1] < arrayTwo[start2]) {
                if (diff > Math.min(diff, Math.abs(arrayOne[start1] - arrayTwo[start2]))) {
                    diff = Math.min(diff, Math.abs(arrayOne[start1] - arrayTwo[start2]));
                    result[0] = arrayOne[start1];
                    result[1] = arrayTwo[start2];
                }
                start1++;
            } else if (arrayOne[start1] > arrayTwo[start2]) {
                if (diff > Math.min(diff, Math.abs(arrayOne[start1] - arrayTwo[start2]))) {
                    diff = Math.min(diff, Math.abs(arrayOne[start1] - arrayTwo[start2]));
                    result[0] = arrayOne[start1];
                    result[1] = arrayTwo[start2];
                }
                start2++;
            } else {
                result[0] = arrayOne[start1];
                result[1] = arrayTwo[start2];
                break;
            }
        }
        return result;
    }
}

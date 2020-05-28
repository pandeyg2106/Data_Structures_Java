package Algorithms.Dynamic_Programming;

import java.util.Arrays;

public class LargestThreeNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int len = array.length;
        int[] result = new int[3];
        for(int i = 0; i < len; i++){
            if(array[i] > result[2]){
                result[0] = result[1];
                result[1] = result[2];
                result[2] = array[i];
            }
            else if(array[i] > result[1]){
                result[0] = result[1];
                result[1] = array[i];
            }
            else if(array[i] > result[0]){
                result[0] = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
        System.out.println(Arrays.toString(findThreeLargestNumbers(input)));
    }
}

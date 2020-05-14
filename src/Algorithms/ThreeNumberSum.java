package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        List<Integer[]> result = new ArrayList<Integer[]>();
        int len = array.length;
        Arrays.sort(array);

        for(int i = 0; i < len-2; i++){
            int left = i + 1;
            int right = len-1;
            while(left < right){
                int currentSum = array[i] + array[left] + array[right];
                if(currentSum < targetSum){
                    left++;
                }
                else if(currentSum > targetSum){
                    right--;
                }

                else{
                    Integer[] tempResult = {array[i],array[left],array[right]};
                    result.add(tempResult);
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}

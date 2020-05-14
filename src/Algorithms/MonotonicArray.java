package Algorithms;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        int start = 0;
        int len = array.length;
        if (array.length < 3) {
            return true;
        }
        while(start < len - 1){
            if(array[start] == array[start + 1]){
                start++;
            }
            else{
                break;
            }
        }
        if(start == len-1){
            return true;
        }
        if (array[start] <= array[start + 1]) {
            start++;
            while (start < len - 1) {
                if (array[start] <= array[start + 1]) {
                    start++;
                } else {
                    return false;
                }
            }
        } else {
            start++;
            while (start < len - 1) {
                if (array[start] >= array[start + 1]) {
                    start++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11};
        System.out.println(isMonotonic(A));
    }
}

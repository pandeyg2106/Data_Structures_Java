package Algorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] numbers = {9,5,6,7,2,3,4,8,1};
        MergeSort sorter = new MergeSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

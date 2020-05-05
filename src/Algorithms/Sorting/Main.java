package Algorithms.Sorting;

import Algorithms.Sorting.CountingSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] numbers = {15, 6, 3, 1, 22, 10, 13};
        CountingSort sorter = new CountingSort();
        sorter.sort(numbers, 22);
        System.out.println(Arrays.toString(numbers));
    }
}

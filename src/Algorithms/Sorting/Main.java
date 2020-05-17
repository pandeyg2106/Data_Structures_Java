package Algorithms.Sorting;

import Algorithms.Sorting.CountingSort;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
/*        int[] numbers = {15, 6, 3, 1, 22, 10, 13};
        CountingSort sorter = new CountingSort();
        sorter.sort(numbers, 22);
        System.out.println(Arrays.toString(numbers));*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-2);
/*        list.add(-1);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(1);*/
        System.out.println(amazonQuestion(list,0));
    }

    //0,-1,0,1,2,1
    public static int amazonQuestion(ArrayList<Integer> A, int k){
        if(A.size() < 2)
            return -1;
        if(A.get(0) == k){
            return 0;
        }
        for(int i = 0; i < A.size(); i++ ){
            if(A.get(i) + 1 == k || A.get(i) - 1 == k)
                return i+1;
        }
        return -1;
    }
}

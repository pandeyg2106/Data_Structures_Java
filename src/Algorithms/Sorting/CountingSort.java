package Algorithms.Sorting;

public class CountingSort {

    public void sort(int[] array, int max){
        var indexes = new int[max+1];
        for(var item : array)
            indexes[item]++;
        int k = 0;
        for(int i = 0; i<indexes.length; i++)
            for(int j = 0; j < indexes[i]; j++)
                array[k++] = i;
    }
}

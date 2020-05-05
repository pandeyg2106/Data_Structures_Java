package Algorithms.Sorting;

public class QuickSort {

    public void sort(int[] array){
        sort(array, 0, array.length - 1);
    }
    //Partition
    //Set boundary as -1, which shows left partition is empty, and set pivot as the last element.
    //Pivot will become boundary and it's position will be correct.
    //Recursively sort the left partition, which be the index of last element of left partition.
    private void sort(int[] array, int start, int end){
        //base condition
        if(start >= end)
            return;
        int boundary = partition(array, start, end);
        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end){
        int pivot = array[end];
        int boundary = start - 1;
        for(int i = start; i <= end; i++)
            if(array[i] <= pivot)
                swap(array, ++boundary, i);
        return boundary;
    }

    private void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}

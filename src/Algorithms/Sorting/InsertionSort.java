package Algorithms.Sorting;

public class InsertionSort {
    public void sort(int[] array){
        //Iterate over the array, but consider first item as sorted.
        for(int i = 1; i < array.length; i++){
            var current = array[i];
            var j = i - 1;
            while(j>=0 && array[j] > current){
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
}

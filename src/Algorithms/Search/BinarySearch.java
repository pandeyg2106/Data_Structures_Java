package Algorithms.Search;

public class BinarySearch {

    public boolean search(int[] array, int item){
        return search(array, item, 0, array.length - 1);
    }

    private boolean search(int[] array, int item, int first, int last){

        if(last < first)
            return false;
        int middle = (first + last) / 2;

        if(item == array[middle])
            return true;
        if(item < array[middle])
            return search(array, item, first, middle - 1);
        return search(array, item, middle + 1, last);

    }
}

package Algorithms.Search;

public class LinearSearch {

    public boolean search(int[] array, int item){
        for(int i = 0; i<array.length; i++){
            if(array[i] == item)
                return true;
        }
        return false;
    }
}

package Algorithms.Search;

public class JumpSearch {

    public int search(int[] array, int item){
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        while(array[next - 1] < item){
            start = next;
            if(start >= array.length)
                break;
            next = next + blockSize;
            if(next > array.length)
                next = array.length;
        }
        for(int i = start; i < next; i++)
            if(array[i] == item)
                return i;
        return -1;
    }
}

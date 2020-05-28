package Algorithms.Dynamic_Programming;

public class SingleCycleCheck {

    // [2, 3, 1, -4, -4, 2]
    public static boolean hasSingleCycle(int[] array) {
        int index = 0;
        int newIndex = -1;
        int count = 0;
        int len = array.length;
        while(newIndex != 0 && count < len){
            count++;
            newIndex = (Math.max(index,newIndex) + array[Math.max(index,newIndex)]) % len;
            if(newIndex < 0)
                newIndex = newIndex + len;
        }
        if(newIndex == index && count == len)
            return true;
        else
            return false;

    }

    public static void main(String[] args){
        int[] input = new int[]{2, 3, 1, -4, -4, 2};
        System.out.println(hasSingleCycle(input));
    }
}

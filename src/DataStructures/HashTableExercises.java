package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class HashTableExercises {

    public int mostFreequentNumber(int[] numbers) {
        //To find most repeated element in an array of integers, we should iterate through array,
        //create key for each element, and if found again, increase the value by 1.
        Map<Integer, Integer> map = new HashMap<>();
        for (var number : numbers) {
            map.put(number, (map.getOrDefault(number, 0)) + 1);
        }
        System.out.println(map);
        int max = -1;
        int result = numbers[0];
        for (var k : map.entrySet()) {
            if (k.getValue() > max) {
                max = k.getValue();
                result = k.getKey();
            }
        }
        return result;
    }



    public static void main(String[] args){
        HashTableExercises obj = new HashTableExercises();
        int[] array = new int[]{1, 2, 2, 3, 3, 3, 4};
        System.out.println(obj.mostFreequentNumber(array));

    }
}

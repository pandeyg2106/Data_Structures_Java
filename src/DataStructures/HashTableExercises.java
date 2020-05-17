package DataStructures;

import  java.util.HashMap;
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

    public int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        int ways = 0;

        createHashTable(str1,map1);
        createHashTable(str2,map2);

        for(var k : map2.entrySet()){
            if(!map1.containsKey(k.getKey()))
                ways++;
            else if(map1.get(k.getKey()) < k.getValue()){
                int  diff = k.getValue() - map1.get(k.getKey());
                ways += diff;
            }
            else if(map1.get(k.getKey()) > k.getValue()){
                int  diff = map1.get(k.getKey()) - k.getValue();
                ways += diff;
            }


        }

        return ways;
    }

    public static void createHashTable(String str,Map<Character,Integer> map){
        for(Character ch : str.toCharArray()){
            if(map.containsKey(ch))
                map.replace(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }
    }





    public static void main(String[] args){
        HashTableExercises obj = new HashTableExercises();
        int[] array = new int[]{1, 2, 2, 3, 3, 3, 4};
        System.out.println(obj.levenshteinDistance("cereal","saturdzz"));

    }
}

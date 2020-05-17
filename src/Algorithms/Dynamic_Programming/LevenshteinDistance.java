package Algorithms.Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2){

        //Input: cereal, saturdzz
        //Output: 5. Number of operations performed on the first string.
        //Operations include: insertion, deletion, substitute
        int ways = 0;
        Map<Character, List<Integer>> map1 = new HashMap<Character,List<Integer>>();
        Map<Character,List<Integer>> map2 = new HashMap<Character,List<Integer>>();

        createHashTable(str1,map1);
        createHashTable(str2,map2);
        //iterate through str2, and for each character check the same in str1.

        for(var k : map2.entrySet()){
            if(!map1.containsKey(k.getKey())){
                map1.put(k.getKey(),k.getValue());
                ways++;
            }
            else{
                if(map1.get(k.getKey()) != k.getValue()){
                    map1.replace(k.getKey(),k.getValue());
                    ways++;
                }

            }
        }

        return ways;
    }

    public static void createHashTable(String str,Map<Character,List<Integer>> map){
        for(int i = 0; i < str.length(); i++){
            List<Integer> value = new ArrayList<>(i);
            if(map.containsKey(str.charAt(i))) {
                value = map.get(str.charAt(i));
                map.put(str.charAt(i), value);
            }
            else
                map.put(str.charAt(i), new ArrayList<>(i));
        }
    }
}

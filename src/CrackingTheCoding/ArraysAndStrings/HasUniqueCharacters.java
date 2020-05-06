package CrackingTheCoding.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class HasUniqueCharacters {
    //A good approach would be to create a Hash Table,
    //and check if a particular key has value more thn 1.
    // If No, return true, else return false.

    //Another approach would be to create a new array of english alphabets
    //and populate the frequency of each element, using the ASCII code -'a'
    //as the index. Increment after every character. Iterate through the array
    //and if any element is greater than 1, return false.

    //Implementation using Hash Tables
    public boolean hasUniqueCharsHash(String str){
        if(str == null)
            return false;
        Map<Character, Integer> hashMap = new HashMap<>();
        for(var ch  : str.trim().toLowerCase().toCharArray()){
            if(!hashMap.containsKey(ch))
                hashMap.put(ch, 1);
            else
                hashMap.put(ch,hashMap.get(ch) + 1);
        }

        for(var k : hashMap.entrySet()){
            if(k.getValue() > 1)
                return false;
        }
        return true;
    }
    //Implementation using Arrays
    public boolean hasUniqueCharArray(String str){
        if(str == null)
            return false;
        final int ALPHABETS_SIZE = 26;
        int[] frequency = new int[ALPHABETS_SIZE];
        str = str.trim().toLowerCase();
        for(int i = 0; i < str.length(); i++) {
            var index = str.charAt(i) - 'a';
            frequency[index]++;
            if(frequency[index] > 1)
                return false;
        }
        return true;
    }
}

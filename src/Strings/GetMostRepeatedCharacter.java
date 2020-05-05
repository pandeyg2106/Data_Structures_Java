package Strings;

import java.util.HashMap;
import java.util.Map;

public class GetMostRepeatedCharacter {

    public char getMostRepeatedChar(String str) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (var ch : str.trim().toLowerCase().toCharArray()) {
            if (!hashMap.containsKey(ch))
                hashMap.put(ch, 1);
            else{
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }
        int max = 0;
        char result = ' ';

        for(var ch : hashMap.entrySet()){
            if(ch.getValue() > max){
                max = ch.getValue();
                result = ch.getKey();
            }
        }
        return result;
    }

    public char getMostRepeatedCharacter(String str){
        //Instead of hashtable, we will use an integer array.
        final int ASCII_SIZE = 256;
        int[] freequencies = new int[ASCII_SIZE];
        for(var ch : str.trim().toLowerCase().toCharArray())
            freequencies[ch]++;

        //Return the index with the maximum value.
        int max = 0;
        char result = ' ';
        for(int i = 0; i<freequencies.length; i++){
            if(freequencies[i] > max){
                max = freequencies[i];
                result = (char)i;
            }
        }
        return result;
    }
}

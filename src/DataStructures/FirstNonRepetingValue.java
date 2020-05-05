package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepetingValue {

    public char charFinder(String str){

        Map<Character,Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for(Character ch : chars){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
           }
            else{
                map.put(ch,1);
            }
        }
        for(var ch : chars){
            if(map.get(ch) > 1)
                return ch;
        }
        return 0;
    }

    public static void main(String[] args){
        FirstNonRepetingValue obj = new FirstNonRepetingValue();
        System.out.println(obj.charFinder("green apple"));
    }

}

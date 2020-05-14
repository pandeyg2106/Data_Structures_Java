package Strings;

import java.util.*;

public class GroupedAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (!anagrams.containsKey(sortedWord))
                anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            else
                anagrams.get(sortedWord).add(word);
        }
        List<List<String>> output = new ArrayList<List<String>>();
        for (Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
            output.add(entry.getValue());
        }
        return output;
    }


    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();
        input.add("yo");
        input.add("act");
        input.add("flop");
        input.add("tac");
        input.add("cat");
        input.add("oy");
        input.add("olfp");
        System.out.println(groupAnagrams(input));
    }
}

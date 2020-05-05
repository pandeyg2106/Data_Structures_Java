package Strings;

public class Anagram {

    public boolean isAnagram(String first, String second){
        if(first == null || second == null)
            return true;
        final int ALPHABET_SIZE = 26;
        int[] frequency = new int[ALPHABET_SIZE];

        //Fill the frequency array based on he characters from first.
        first.toLowerCase();
        for(int i = 0; i < first.length(); i++)
            frequency[first.charAt(i) - 'a']++;

        //Iterate over second array, and decrement the values at each index.
        // The frequency array should have all values
        // as zero only after the iteration ends.
        second.toLowerCase();
        for(int i = 0; i < second.length(); i++) {
            var index = second.charAt(i) - 'a';
            if (frequency[index] == 0)
                return false;

            frequency[index]--;
        }
        return true;
    }
}

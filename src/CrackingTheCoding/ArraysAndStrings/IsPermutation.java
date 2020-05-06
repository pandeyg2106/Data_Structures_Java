package CrackingTheCoding.ArraysAndStrings;

public class IsPermutation {

    public boolean isPermutation(String first, String second){
        if(first == null || second == null)
            return false;
        final int ALPHABETS_SIZE = 26;
        int[] frequency = new int[ALPHABETS_SIZE];
        first.toLowerCase();
        for(int i = 0; i < first.length(); i++){
            frequency[first.charAt(i) - 'a']++;
        }
        for(int i = 0; i < second.length(); i++){
            var index = second.charAt(i) - 'a';
            if(frequency[index] == 0)
                return false;
            frequency[index]--;
        }
        return true;
        }
}

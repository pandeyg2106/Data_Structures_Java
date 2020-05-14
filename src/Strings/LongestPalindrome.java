package Strings;

public class LongestPalindrome {

    //Assume the first character is already a palindrome.
    //Start from the second character.
    public static String longestPalindromicSubstring(String str){
        int[] longest = {0,1};
        for(int i = 1; i < str.length(); i++){
            int[] odd = getLongestPalindromeFrom(str,i-1,i+1);
            int[] even = getLongestPalindromeFrom(str,i-1,i);
            int[] currentLongest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = longest[1] - longest[0] > currentLongest[1] - currentLongest[0] ? longest : currentLongest;
        }
        return str.substring(longest[0],longest[1]);
    }

    private static int[] getLongestPalindromeFrom(String str, int start, int end) {
        while(start >= 0 && end < str.length()){
            if(str.charAt(start) == str.charAt(end)){
                start--;
                end++;
            }
            else
                break;
        }
        return new int[] {start+1,end};
    }

    public static void main(String[] args){
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }

}

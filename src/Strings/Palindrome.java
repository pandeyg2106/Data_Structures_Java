package Strings;

public class Palindrome {
    
    public boolean isPalindrome(String str){
        str = str.toLowerCase();
        if(str == null)
            return false;
        boolean result = false;
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) == str.charAt(str.length() - 1 - i))
                result = true;
            else
                return false;
        }
         return result;
    }
}

package Strings;

public class StringReversal {

    public String reverse(String str){
        if(str == null)
            return "";
        StringBuilder reversed = new StringBuilder();
        for(var i = str.length() - 1; i >=0; i--)
            reversed.append(str.charAt(i));
        return reversed.toString();
    }
}

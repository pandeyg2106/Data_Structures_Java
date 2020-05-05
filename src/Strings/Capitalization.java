package Strings;

public class Capitalization {
    //Capitalize the first letters of each word.

    public String capitalize(String str){
        if(str == null || str.trim().isEmpty())
            return "";
        String[] words = str.trim().replaceAll(" +"," ").split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }
}

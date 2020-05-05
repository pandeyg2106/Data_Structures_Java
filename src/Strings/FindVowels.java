package Strings;

public class FindVowels {

    public int findVowels(String str){
        if(str == null)
            return 0;
        int vowelCount = 0;
        var vowels = "aeiou";
        for(Character ch: str.toLowerCase().toCharArray()){
            if(vowels.indexOf(ch) != -1)
                vowelCount++;
        }
        return vowelCount;
    }
}

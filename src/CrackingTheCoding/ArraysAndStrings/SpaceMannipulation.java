package CrackingTheCoding.ArraysAndStrings;

public class SpaceMannipulation {

    public String spaceManipulation(String str){
        String[] words = str.split(" ");
        String result = "";
        for(int i = 0; i < words.length-1; i++){
            result += words[i] + "%20";
        }
        return result + words[words.length-1];
    }
}

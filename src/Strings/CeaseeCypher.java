package Strings;

public class CeaseeCypher {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        if(str == null || str.isEmpty())
            return null;
        StringBuilder result = new StringBuilder();
        int newKey = key % 26;
        for( Character ch : str.toCharArray()){
            result.append(getNewLetter(ch,newKey));
        }
        return result.toString().toLowerCase();
    }

    public static char getNewLetter(char letter, int key){
        int newLetter = letter + key;
        if(newLetter <= 122)
            return (char)newLetter;
        else
            return (char) (96 + newLetter % 122);
    }

    public static void main(String[] args){
        System.out.println(caesarCypherEncryptor("xyz",2));
    }
}

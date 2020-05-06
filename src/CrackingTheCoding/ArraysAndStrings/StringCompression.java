package CrackingTheCoding.ArraysAndStrings;


public class StringCompression {
    public String compressString(String str){
        //Given aabcccccaaa
        //return a2b1c5a3.
        //Map will not work as we want duplicates too.
        if(str == null)
            return null;
        var charArray = str.trim().toCharArray();
        var result = new StringBuilder();
        int count;
        for(int i = 0; i < charArray.length; i += count){
            result.append(charArray[i]);
            int temp = 1;
            try {
                while(charArray[i] == charArray[i + temp]){
                    temp ++;
                }
            } catch (Exception ArrayIndexOutOfBoundsException) {
                result.append(temp);
                return result.toString();
            }
            result.append(temp);
            count = temp;
        }
        return result.toString();
    }
}

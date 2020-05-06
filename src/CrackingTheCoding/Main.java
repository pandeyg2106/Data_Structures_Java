package CrackingTheCoding;

import CrackingTheCoding.ArraysAndStrings.HasUniqueCharacters;
import CrackingTheCoding.ArraysAndStrings.SpaceMannipulation;
import CrackingTheCoding.ArraysAndStrings.StringCompression;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        var obj = new Main();
        System.out.println(obj.solution(15));
    }

    public int solution(int N) {
        // write your code in Java SE 8
        ArrayList<Integer> binaryList= getBinary(N);
        ArrayList<Integer> allOnes = new ArrayList();
        var result = 0;
        for(int i = 0; i<binaryList.size(); i++){
            if(binaryList.get(i) > 0){
                allOnes.add(i);
            }
        }
        if(allOnes.size() <= 1){
            return 0;
        }
        for(int j = 0; j<allOnes.size()-1; j++){
            if((allOnes.get(j + 1) - allOnes.get(j)) -1 > result){
                result = (allOnes.get(j + 1) - allOnes.get(j)) -1;
            }
        }
        return result;

    }

    public ArrayList<Integer> getBinary(int num){

        var binary = new ArrayList();
        int index = 0;
        while(num > 0){
            int rem = num%2;
            binary.add(rem);
            num = num/2;
        }
        return binary;
    }
}

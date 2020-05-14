package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class MoveArrayToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int start = 0;
        int end = array.size()- 1;

        while(start < end){
            if(array.get(end) == toMove){
                end--;
            }
            else if(end != toMove){
                if(array.get(start) == toMove){
                    array.set(start,array.get(end));
                    array.set(end,toMove);
                    end--;
                    start++;
                }
                else{
                    start++;
                }
            }
        }
        return array;
        }


    public static void main(String[] args){
        List<Integer> input = new ArrayList<>();
//        input.add(2);
//        input.add(1);
//        input.add(2);
//        input.add(2);
//        input.add(2);
//        input.add(3);
//        input.add(4);
//        input.add(2);

        System.out.println(moveElementToEnd(input,2));;
    }
}

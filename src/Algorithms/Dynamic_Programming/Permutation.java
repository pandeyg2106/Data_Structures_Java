package Algorithms.Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> perms = new ArrayList<List<Integer>>();
        createPermutations(array, new ArrayList<Integer>(), perms);
        return perms;
    }

    public static void createPermutations(List<Integer> arr, List<Integer> perm, List<List<Integer>> perms) {

        if (arr.size() == 0 && perm.size() > 0)
            perms.add(perm);
        else {
            for (int i = 0; i < arr.size(); i++) {
                List<Integer> newArray = new ArrayList<Integer>(arr);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<Integer>(perm);
                newPermutation.add(arr.get(i));
                createPermutations(newArray, newPermutation, perms);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(getPermutations(A));
    }
}

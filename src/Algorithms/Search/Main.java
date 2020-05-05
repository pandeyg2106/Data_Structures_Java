package Algorithms.Search;

public class Main {
    public static void main(String[] args){
        int[] numbers = {1, 3, 6, 10, 13, 15, 22};
        var search = new JumpSearch().search(numbers, 23);
        System.out.println(search);
    }
}

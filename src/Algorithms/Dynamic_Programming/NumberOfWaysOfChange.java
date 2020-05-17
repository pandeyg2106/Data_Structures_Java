package Algorithms.Dynamic_Programming;

public class NumberOfWaysOfChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int len = denoms.length;
        int [] ways = new int[n+1];
        ways[0] = 1;
        for(int denom : denoms){
            for(int amount = 1; amount < n+1; amount++){
                if(denom <= amount){
                    ways[amount] = ways[amount] + ways[amount-denom];
                }
            }
        }
        return ways[n];
    }



    public static void main(String[] args){
        int[] input = new int[]{1, 5, 10, 25};
        System.out.println(numberOfWaysToMakeChange(10,input));
    }
}

package Algorithms;

import java.util.Arrays;

public class MinimumCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n+1];
        Arrays.fill(ways,Integer.MAX_VALUE);
        ways[0] = 0;
        int toCompare = 0;
        for(int denom : denoms){
            for(int amount = 0; amount < n+1; amount++){
                if(denom <= amount){
                    if(ways[amount-denom] == Integer.MAX_VALUE){
                        toCompare = ways[amount - denom];
                    }
                    else{
                        toCompare = ways[amount-denom] + 1;
                    }
                    ways[amount] = Math.min(ways[amount],toCompare);
                }
            }
        }
        return ways[n] != Integer.MAX_VALUE ? ways[n] : -1;
    }

    public static void main(String[] args){
        int[] input = new int[]{1, 5, 10};
        System.out.println(minNumberOfCoinsForChange(7,input));
    }
}
